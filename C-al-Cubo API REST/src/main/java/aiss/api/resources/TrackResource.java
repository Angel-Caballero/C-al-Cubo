package aiss.api.resources;

import aiss.model.repository.MapWeatherRepository;
import aiss.model.repository.WeatherRepository;

public class TrackResource {

	private static TrackResource _instance=null;
	WeatherRepository repository;
	
	private TrackResource() {
		repository = MapWeatherRepository.getInstance();
	}

	
	public static TrackResource getInstance() {
		if(_instance==null) {
			_instance = new TrackResource();
		}
		return _instance;
	}
}
