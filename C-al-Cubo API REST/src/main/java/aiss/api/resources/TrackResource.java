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
	
	//Methods related to tracks
	@GET
	@Produces("application/json")
	public Collection<Track> getAllTracks(){
		return repository.getAllTracks();
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createTrack(@Context UriInfo uriInfo, Track track) {
		if(track.getTitle() == null || "".equals(track.getTitle())) {
			throw new BadRequestException("The tittle of the track must not be null.");
		}
		
		repository.addTrack(track);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(track.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(track);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateTrack(Track track) {
		Track oldTrack = repository.getTrack(track.getId());
		
		if(oldTrack == null) {
			throw new NotFoundException("The track with id = " + track.getId() + " was not found.");
		}
		
		if(track.getTitle() != null) {
			oldTrack.setTitle(track.getTitle());
		}
		
		if(track.getAlbum() != null) {
			oldTrack.setAlbum(track.getAlbum());
		}
		
		if(track.getArtist() != null) {
			oldTrack.setArtist(track.getArtist());
		}
		
		if(track.getYear() != null) {
			oldTrack.setYear(track.getYear());
		}
		
		return Response.noContent().build();
	}
	
	
	@GET
	@Path("/{trackId}")
	@Produces("application/json")
	public Track getTrack(@PathParam("trackId") String trackId) {
		Track track = repository.getTrack(trackId);
		
		if(track == null) {
			throw new NotFoundException("The track with id = " + trackId + " was not found.");
		}
		
		return track;
	}
	
	
	@DELETE
	@Path("/{trackId}")
	public Response deleteTrack(@PathParam("trackId") String trackId) {
		Track track = repository.getTrack(trackId);
		
		if(track == null) {
			throw new NotFoundException("The track with id = " + trackId + " was not found.");
		}
		
		repository.deleteTrack(trackId);
		
		return Response.noContent().build();
	}
}
