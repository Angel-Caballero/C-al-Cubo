package aiss.controller.weatherbit;

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
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.resources.PlayListsResource;
import aiss.model.resources.WeatherResource;
import aiss.model.weatherbit.Forecast;

public class WeatherMusicController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(WeatherMusicController.class.getName());

	public WeatherMusicController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String accessToken = (String) request.getSession().getAttribute("Youtube-token");


		RequestDispatcher rd = null;

		//Comprobamos que el token existe
//		if (accessToken != null && !"".equals(accessToken)) {
			log.log(Level.INFO, "Procesando WeatherController.");

			//Obtenemos los parámetros
			String country = request.getParameter("country");
			String city = request.getParameter("city");
			WeatherResource wr = new WeatherResource();
			Forecast forecast = wr.getForecast(country, city);

			log.log(Level.FINE, "Open Weather Response: " + forecast);

			//Comprobamos que el tiempo que se nos devuelva no sea nulo
			if (forecast != null) {
				log.log(Level.FINE, "Retrieved weather of " + city + ", "+ country + " succesfully");
				rd = request.getRequestDispatcher("/weather.jsp");
				String weather = wr.getWeather(forecast);
				request.setAttribute("weather", weather);

				// Search for PlayLists
				PlayListsResource plr = new PlayListsResource();
				PlayListSearch busquedaPlayList = plr.getPlayLists(weather);

				//Comprobamos que la PlayList devuelta con el tiempo actual no sea nula y no este vacia
				if (busquedaPlayList != null && !Arrays.asList(busquedaPlayList.getData()).isEmpty()) {
					log.log(Level.FINE, "Retrieved playlists with the search query '" + weather + "' succesfully");
					String playlist = PlayListsResource.getFirstPlayList(busquedaPlayList).getTitle();
					List<TrackData> busquedaTracks = plr.getTracks(busquedaPlayList);
					request.setAttribute("playlist", playlist);

					//Comprobamos si la lista de Tracks  que se devuelve no es null
					if (busquedaTracks != null) {
						log.log(Level.FINE, "Retrieved tracks from the playlist succesfully");
						request.setAttribute("tracks", busquedaTracks);
						request.setAttribute("error", "");
					}
					//Caso de que se devuelva una lista nula con una el tiempo actual
					else {
						log.log(Level.SEVERE, "Could not retrieve tracks from the playlist " + weather + " succesfully");
						request.setAttribute("mensajeError", "Could not retrieve tracks from the playlist " + weather + " succesfully");
						rd = request.getRequestDispatcher("/error.jsp");
					}
				}
				//Caso de que no se encuentren PlayLists con el tiempo actual
				else if(Arrays.asList(busquedaPlayList.getData()).isEmpty()) {
					log.log(Level.FINE, "There are no playlists with the search query: '" + weather + "'");
					String weatherForecast = "Weather Forecast";
					busquedaPlayList = plr.getPlayLists(weatherForecast);

					//Comprobamos si hay PlayList con una query determinada o si se devuelve null
					if (busquedaPlayList != null && !Arrays.asList(busquedaPlayList.getData()).isEmpty()) {
						log.log(Level.FINE, "Retrieved playlists with the search query '" + weatherForecast + "' succesfully");
						String playlist = PlayListsResource.getFirstPlayList(busquedaPlayList).getTitle();
						List<TrackData> busquedaTracks = plr.getTracks(busquedaPlayList);
						request.setAttribute("playlist", playlist);

						//Comprobamos si la lista de Tracks  que se devuelve no es null
						if (busquedaTracks != null) {
							log.log(Level.FINE, "Retrieved tracks from the playlist succesfully");
							request.setAttribute("tracks", busquedaTracks);
							request.setAttribute("error", "There are no playlists with the search query: '" + weather + "'");

						}
						//Caso de que se devuelva una lista nula con una query determinada
						else {
							log.log(Level.SEVERE, "Could not retrieve tracks from the playlist " + weatherForecast + " succesfully");
							request.setAttribute("mensajeError", "Could not retrieve tracks from the playlist " + weatherForecast + " succesfully");
							rd = request.getRequestDispatcher("/error.jsp");
						}
					}
					//Caso de que la PlayList con el tiempo actual sea nulo
					else {
						log.log(Level.SEVERE, "Could not retrieve playlists with the search query " + weather + " succesfully");
						request.setAttribute("mensajeError", "Could not retrieve playlists with the search query " + weather + " succesfully");
						rd = request.getRequestDispatcher("/error.jsp");
					}
				}
			}
			//Caso de que el tiempo que se devuelva sea nulo
			else {
				log.log(Level.SEVERE, "No se pudo obtener el clima de "+ city + ", " + country + ".");
				request.setAttribute("mensajeError", "No se pudo obtener el clima de "+ city + ", " + country + ".");
				rd = request.getRequestDispatcher("/error.jsp");
			}
//		}	
//		else {
//			log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
//			rd = request.getRequestDispatcher("/AuthController/Youtube");
//		}
		rd.forward(request, response);
	}
}

