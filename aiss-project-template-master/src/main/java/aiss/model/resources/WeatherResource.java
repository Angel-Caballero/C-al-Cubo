package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.controller.openweather.WeatherController;
import aiss.model.openweather.Forecast;
import aiss.model.openweather.Weather;

public class WeatherResource{
	  private static String URI = "api.openweathermap.org/data/2.5/weather?";
	 // api.openweathermap.org/data/2.5/weather?q={city name},{country code}
	  private static String API_KEY = "eaddc12fe18c112838e912e6534cb747";
	  private static final Logger log = Logger.getLogger(WeatherResource.class.getName());

	public Forecast getForecast(String qCountry, String qCity)throws UnsupportedEncodingException {
	  String country = URLEncoder.encode(qCountry.toLowerCase(), "UTF-8");
	  String city = URLEncoder.encode(qCity, "UTF-8");
	  String uri = URI + "q="+ city + "," + country + "&appid=" + API_KEY;
	  log.log(Level.INFO, "Procesando getForecast");

	  ClientResource cr = null;
	  Forecast weather = null;
	  try {
	    cr = new ClientResource(uri);
	    weather = cr.get(Forecast.class);
	  } catch (ResourceException re) {
	    System.err.println("Error when retrieving the weather: " + cr.getResponse().getStatus());
	  }
	    return weather;
	}

	public String getWeather(Forecast forecast)throws UnsupportedEncodingException {
		Weather[] aux = forecast.getWeather();
		return aux[0].getMain();
	}
	public String getCityId (Forecast forecast) {
		return forecast.getId();
	}
}
