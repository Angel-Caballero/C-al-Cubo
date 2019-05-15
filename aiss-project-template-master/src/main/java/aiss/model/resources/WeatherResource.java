package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.weatherbit.Data;
import aiss.model.weatherbit.Forecast;
import aiss.model.weatherbit.Weather;

public class WeatherResource{
	  private static String URI = "https://api.weatherbit.io/v2.0/current?";
	 // api.openweathermap.org/data/2.5/weather?q={city name},{country code}
	  private static String API_KEY = "bfb5114a9826437986cdf369cb47a6a3";
	  private static final Logger log = Logger.getLogger(WeatherResource.class.getName());

	public Forecast getForecast(String qCountry, String qCity)throws UnsupportedEncodingException {
	  String country = URLEncoder.encode(qCountry, "UTF-8");
	  String city = URLEncoder.encode(qCity, "UTF-8");
	  String uri = URI + "city="+ city + "&country=" + country + "&key=" + API_KEY;
	  log.log(Level.FINE, "Open Weather URI: " + uri);

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
		Data[] aux = forecast.getData();
		Weather aux2 = aux[0].getWeather();
		return aux2.getDescription();
		
	}
	
}
