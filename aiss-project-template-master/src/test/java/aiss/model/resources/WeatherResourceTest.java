package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.weatherbit.Data;
import aiss.model.weatherbit.Forecast;
import aiss.model.weatherbit.Weather;

public class WeatherResourceTest {

	static WeatherResource wr = new WeatherResource();
	
	@Test
	public void testGetForecast() throws UnsupportedEncodingException{
		Forecast forecast = wr.getForecast("es", "Sevilla");
		
		assertNotNull("The forecast is null", forecast);
		
		//Show the result
		System.out.println(forecast);
	}
	
	@Test
	public void testGetWeather() throws UnsupportedEncodingException {
		Forecast forecast = new Forecast();
		Weather weather = new Weather();
		Weather aux = new Weather();
		Data dataAux = new Data();
		
		weather.setCode("1");
		aux.setCode("1");
		weather.setDescription("1");
		aux.setDescription("1");
		weather.setIcon("1");
		aux.setIcon("1");
		dataAux.setWeather(weather);
		Data[] data = {dataAux};
		forecast.setData(data);
		
		assertEquals("The weather do not match", wr.getWeather(forecast), aux.getDescription());
		
		//Show result
		
		System.out.println("The weather is: " + aux);
	}
}
