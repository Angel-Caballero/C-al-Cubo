package aiss.controller.googlecalendar;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.calendarific.Calendarific;
import aiss.model.calendarific.Date;
import aiss.model.calendarific.Holidays;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.resources.CalendarResource;
import aiss.model.resources.HolidaysResource;
import aiss.model.resources.PlayListsResource;

public class CalendarController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarController.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendarController() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accessToken = (String) request.getSession().getAttribute("GoogleCalendar-token");

		// Request data
		RequestDispatcher rd = null;

		//Comprobamos que el token de acceso no sea ni nulo ni vacio	
		if (accessToken != null && !"".equals(accessToken)) {
			CalendarResource cr = new CalendarResource(accessToken);
			String country = request.getParameter("country");
			String closestHoliday = request.getParameter("closestHoliday");
			request.setAttribute("closestHoliday", closestHoliday);
			String holidayName = request.getParameter("holidayName");
			String holidayDescription = request.getParameter("holidayDescription");
			String holidayIso = request.getParameter("holidayIso");
			if(!cr.existsCalendar()) {
				cr.createCalendar();
			}
			String calendarId = cr.getCalendarId();
			Holidays holiday = new Holidays();
			holiday.setName(holidayName);
			holiday.setDescription(holidayDescription);
			Date date = new Date();
			date.setIso(holidayIso);
			holiday.setDate(date);
			Boolean exitoEvento = cr.createEvent(calendarId, holiday);
			//Comprobamos que se haya creado el evento con exito
			if(exitoEvento) {
				//Recuperamos las tracks y las holidays	
				HolidaysResource hr = new HolidaysResource();
				Calendarific calendar = hr.getHolidays(country);
				request.setAttribute("holidays", hr.getHolidaysInActualMonth(calendar.getResponse().getHolidays()));
				// Search for PlayLists
				PlayListsResource plr = new PlayListsResource();
				PlayListSearch busquedaPlayList = plr.getPlayLists(closestHoliday);

				//Comprobamos si hay PlayList con el nombre de la festividad mas cercana o si se devuelve null
				if (busquedaPlayList != null && !Arrays.asList(busquedaPlayList.getData()).isEmpty()) {
					log.log(Level.FINE, "Retrieved playlists with the search query '" + closestHoliday + "' succesfully");
					String playlist = PlayListsResource.getFirstPlayList(busquedaPlayList).getTitle();
					List<TrackData> busquedaTracks = plr.getTracks(busquedaPlayList);
					request.setAttribute("playlist", playlist);

					//Comprobamos si la lista de Tracks  que se devuelve no es null
					if (busquedaTracks != null) {
						log.log(Level.FINE, "Retrieved tracks from the playlist succesfully");
						request.setAttribute("tracks", busquedaTracks);
						request.setAttribute("error", "");

						//Caso de recibamos una lista nula 
					}else {
						log.log(Level.SEVERE, "Could not retrieve tracks from the playlist " + closestHoliday + " succesfully");
						request.setAttribute("mensajeError", "Could not retrieve tracks from the playlist " + closestHoliday + " succesfully");
						rd = request.getRequestDispatcher("/error.jsp");
					}

					//Caso de que no se encuentren PlayLists con la nombre de la festividad mas cercana
				}else if(Arrays.asList(busquedaPlayList.getData()).isEmpty()) {
					log.log(Level.FINE, "There are no playlists with the search query: '" + closestHoliday + "'");
					
					String actualMonth = hr.getMonthName();
					busquedaPlayList = plr.getPlayLists(actualMonth);

					//Comprobamos si hay PlayList con el nombre del mes actual o si se devuelve null
					if (busquedaPlayList != null && !Arrays.asList(busquedaPlayList.getData()).isEmpty()) {
						log.log(Level.FINE, "Retrieved playlists with the search query '" + actualMonth + "' succesfully");
						String playlist = PlayListsResource.getFirstPlayList(busquedaPlayList).getTitle();
						List<TrackData> busquedaTracks = plr.getTracks(busquedaPlayList);
						request.setAttribute("playlist", playlist);

						//Comprobamos si la lista de Tracks  que se devuelve no es null
						if (busquedaTracks != null) {
							log.log(Level.FINE, "Retrieved tracks from the playlist succesfully");
							request.setAttribute("tracks", busquedaTracks);
							request.setAttribute("error", "There are no playlists with the search query: '" + closestHoliday + "'");


						}
						//Caso de que se devuelva una lista nula con el nombre del mes actual
						else {
							log.log(Level.SEVERE, "Could not retrieve tracks from the playlist " + actualMonth + " succesfully");
							request.setAttribute("mensajeError", "Could not retrieve tracks from the playlist " + actualMonth + " succesfully");
							rd = request.getRequestDispatcher("/error.jsp");
						}
					}
					//Caso de que se devuelva una lista nula con la festividad mas cercana
					else {
						log.log(Level.SEVERE, "Could not retrieve playlists with the search query " + closestHoliday + " succesfully");
						request.setAttribute("mensajeError", "Could not retrieve playlists with the search query " + closestHoliday + " succesfully");
						rd = request.getRequestDispatcher("/error.jsp");
					}

				}

			}
			//Caso de que no se haya podido crear correctamente el evento
			else {
				log.log(Level.SEVERE, "El evento no se ha podido crear correctamente");
				request.setAttribute("mensajeError", "El evento no se ha podido crear correctamente");
				rd = request.getRequestDispatcher("/error.jsp");
			}
		}
		//Caso de que el token no exista		
		else {
			log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
			rd = request.getRequestDispatcher("/AuthController/GoogleCalendar");
		}

		// Forward to holidays view
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
