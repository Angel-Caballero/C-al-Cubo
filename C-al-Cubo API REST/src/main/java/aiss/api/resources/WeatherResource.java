package aiss.api.resources;

import java.net.URI;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;
import aiss.model.Playlist;
import aiss.model.Track;
import aiss.model.Weather;
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
	
	
	//Methods related to weather
	@GET
	@Produces("application/json")
	public Collection<Weather> getAllWeather(){
		return repository.getAllWeathers();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Weather get(@PathParam("id") String id) {
		Weather weather = repository.getWeather(id);
		if(weather == null) {
			throw new NotFoundException("The weather with id="+ id +" was not found.");
		}
		return weather;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addWeather(@Context UriInfo uriInfo, Weather weather) {
		if(weather.getName() == null || "".equals(weather.getName())) {
			throw new BadRequestException("The name of the weather must not be null.");
		}
		if(weather.getPlaylist() != null) {
			throw new BadRequestException("The playlist property is not editable.");
		}
		
		repository.addWeather(weather);
		
		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(weather.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(weather);			
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateWeather(Weather weather) {
		Weather oldWeather = repository.getWeather(weather.getId());
		if(oldWeather == null) {
			throw new NotFoundException("The weather with id="+ weather.getId() +" was not found.");
		}
		if(weather.getPlaylist() != null) {
			throw new BadRequestException("The playlist property is not editable.");
		}
		
		// Update name
		if (weather.getName() != null) {
			oldWeather.setName(weather.getName());
		}
			
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeWeather(@PathParam("id") String id) {
		Weather oldWeather = repository.getWeather(id);
		if(oldWeather == null) {
			throw new NotFoundException("The weather with id="+ id +" was not found.");
		}else {
			repository.deleteWeather(id);
		}
		return Response.noContent().build();
	}
	
	
	//Methods related to playlist
	@POST
	@Path("/{weatherId}/{playlistId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response setPlaylist(@Context UriInfo uriInfo, @PathParam("weatherId") String weatherId, @PathParam("playlistId") String playlistId) {
		Weather weather = repository.getWeather(weatherId);
		Playlist playlist = repository.getPlaylist(playlistId);
		
		if(weather == null) {
			throw new NotFoundException("The weather with id=" + weatherId + " was not found.");
		}
		
		if(playlist == null) {
			throw new NotFoundException("The playlist with id=" + playlistId + " was not found.");
		}
		
		if(weather.getPlaylist().getId().equals(playlist.getId())) {
			throw new BadRequestException("This playlist is the weather´s playlist already.");
		}
		
		repository.setPlaylist(weatherId, playlistId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(playlistId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(playlist);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{weatherId}")
	public Response removePlaylist(@PathParam("weatherId") String weatherId) {
		Weather weather = repository.getWeather(weatherId);
		
		if(weather == null) {
			throw new NotFoundException("The weather with id=" + weatherId + " was not found.");
		}
		
		if(weather.getPlaylist() == null) {
			throw new BadRequestException("This weather doesn´t have playlist already.");
		}
		
		repository.removePlaylist(weatherId);
		return Response.noContent().build();
	}
	
	
	//Methods related to track
	@POST
	@Path("/{playlistId}/{trackId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addTrack(@Context UriInfo uriInfo, @PathParam("playlistId") String playlistId, @PathParam("trackId") String trackId) {
		Playlist playlist = repository.getPlaylist(playlistId);
		Track track = repository.getTrack(trackId);
		
		if(playlist==null) {
			throw new NotFoundException("The playlist with id=" + playlistId + " was not found.");
		}
		
		if(track == null) {
			throw new NotFoundException("The song with id=" + trackId + " was not found.");
		}
		
		if(playlist.getTrack(trackId) != null) {
			throw new BadRequestException("The track is already included in the playlist.");
		}
		
		repository.addTrack(playlistId, trackId);
		
		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(playlistId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(playlist);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{playlistId}/{trackId}")
	public Response removeSong(@PathParam("playlistId") String playlistId, @PathParam("trackId") String trackId) {
		Playlist playlist = repository.getPlaylist(playlistId);
		Track track = repository.getTrack(trackId);
		
		if(playlist==null) {
			throw new NotFoundException("The playlist with id=" + playlistId + " was not found.");
		}
		
		if(track == null) {
			throw new NotFoundException("The song with id=" + trackId + " was not found.");
		}
		
		repository.removeTrack(playlistId, trackId);
		return Response.noContent().build();
	}
	
}
