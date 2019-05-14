package aiss.controller.calendarific;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.calendarific.Calendarific;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.resources.HolidaysResource;
import aiss.model.resources.PlayListsResource;

public class HolidaysMusicController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(HolidaysMusicController.class.getName());

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public HolidaysMusicController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String country = request.getParameter("country");
		RequestDispatcher rd = null;
		log.log(Level.INFO, "Procesando HolidaysMusicController");
		// Search for Holidays
		HolidaysResource hr = new HolidaysResource();
		Calendarific calendar = hr.getHolidays(country);
		
		if (calendar != null) {
			log.log(Level.FINE, "Retrieved holidays of the country " + country + " succesfully");
			rd = request.getRequestDispatcher("/holidays.jsp");
			// Solamente se pasan las vacaciones del mes actual
			request.setAttribute("holidays", hr.getHolidaysInActualMonth(calendar.getResponse().getHolidays()));
			String closestHoliday = hr.getClosestHoliday(calendar.getResponse().getHolidays());
			request.setAttribute("closestHoliday", closestHoliday);
			
			// Search for PlayLists
			PlayListsResource plr = new PlayListsResource();
			PlayListSearch busquedaPlayList = plr.getPlayLists(closestHoliday);
			
			if (busquedaPlayList != null) {
				log.log(Level.FINE, "Retrieved playlists with the search query '" + closestHoliday + "' succesfully");
				List<TrackData> busquedaTracks = plr.getTracks(busquedaPlayList);
				
					log.log(Level.FINE, "Retrieved tracks from the playlist succesfully");
					request.setAttribute("tracks", busquedaTracks);
					request.setAttribute("playlist", PlayListsResource.getFirstPlayList(busquedaPlayList).getTitle());
				
			}else {
				log.log(Level.SEVERE, "Could not retrieve playlists with the search query " + closestHoliday + " succesfully");
				rd = request.getRequestDispatcher("/error.jsp");
			}
			
		}else {
			log.log(Level.SEVERE, "El calendario del pais " + country + " no tiene datos");
			rd = request.getRequestDispatcher("/error.jsp");
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
