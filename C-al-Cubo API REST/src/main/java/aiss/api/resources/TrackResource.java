package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import aiss.model.Track;
import aiss.model.repository.MapWeatherRepository;
import aiss.model.repository.WeatherRepository;

@Path("/tracks")
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
	
	
	@GET
	@Produces("application/json")
	public Collection<Track> getAllTracks(){
		return repository.getAllTracks();
	}
}
