package aiss.api.resources;

import javax.ws.rs.Path;

import aiss.model.repository.MapWeatherRepository;
import aiss.model.repository.WeatherRepository;

@Path("/weather")
public class WeatherResource {
	
	private static WeatherResource _instance=null;
	WeatherRepository repository;
	
	private WeatherResource() {
		repository = MapWeatherRepository.getInstance();
	}

	
	public static WeatherResource getInstance() {
		if(_instance==null) {
			_instance = new WeatherResource();
		}
		return _instance;
	}
}
