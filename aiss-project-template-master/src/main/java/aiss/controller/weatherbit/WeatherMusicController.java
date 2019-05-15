package aiss.controller.weatherbit;

import java.io.IOException;
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
		RequestDispatcher rd = null;

		
		log.log(Level.INFO, "Procesando WeatherController.");
		
		//Obtenemos los parámetros
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		WeatherResource wr = new WeatherResource();
		Forecast forecast = wr.getForecast(country, city);
		
		log.log(Level.FINE, "Open Weather Response: " + forecast);
				
		if (forecast != null) {
			log.log(Level.FINE, "Retrieved weather of " + city + ", "+ country + " succesfully");
			rd = request.getRequestDispatcher("/weather.jsp");
			String weather = wr.getWeather(forecast);
			request.setAttribute("weather", weather);
			
			// Search for PlayLists
			PlayListsResource plr = new PlayListsResource();
			PlayListSearch busquedaPlayList = plr.getPlayLists(weather);
			
			if (busquedaPlayList != null) {
				log.log(Level.FINE, "Retrieved playlists with the search query '" + weather + "' succesfully");
				List<TrackData> busquedaTracks = plr.getTracks(busquedaPlayList);
				
					log.log(Level.FINE, "Retrieved tracks from the playlist succesfully");
					request.setAttribute("tracks", busquedaTracks);
					request.setAttribute("playlist", PlayListsResource.getFirstPlayList(busquedaPlayList).getTitle());
				
			}else {
				log.log(Level.SEVERE, "Could not retrieve playlists with the search query " + weather + " succesfully");
				rd = request.getRequestDispatcher("/error.jsp");
			}
		}
		else {
			log.log(Level.SEVERE, "No se pudo obtener el clima de "+ city + ", " + country + ".");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
}
