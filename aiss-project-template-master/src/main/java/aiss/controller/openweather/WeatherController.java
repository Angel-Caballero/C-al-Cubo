package aiss.controller.openweather;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.openweather.Forecast;
import aiss.model.resources.WeatherResource;

public class WeatherController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(WeatherController.class.getName());

	public WeatherController() {
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
				
		if (forecast != null) {
			log.log(Level.FINE, "Retrieved weather of " + city + ", "+ country + " succesfully");
			rd = request.getRequestDispatcher("/weather.jsp");
			request.setAttribute("weather", wr.getWeather(forecast));
			request.setAttribute("cityId", wr.getCityId(forecast));
		}
		else {
			log.log(Level.SEVERE, "No se pudo obtener el clima de "+ city + ", " + country + ".");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
}
