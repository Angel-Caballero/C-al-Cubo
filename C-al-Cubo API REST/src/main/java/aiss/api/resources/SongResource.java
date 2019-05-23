package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;
import aiss.model.Track;
import aiss.model.repository.MapPlaylistRepository;
import aiss.model.repository.PlaylistRepository;
import java.net.URI;
import java.util.Collection;


@Path("/songs")
public class SongResource {

	public static SongResource _instance=null;
	PlaylistRepository repository;
	
	private SongResource(){
		repository=MapPlaylistRepository.getInstance();
	}
	
	public static SongResource getInstance()
	{
		if(_instance==null)
			_instance=new SongResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Track> getAll()
	{
		return repository.getAllTracks();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Track get(@PathParam("id") String trackId)
	{
		Track song = repository.getTrack(trackId);
		
		if(song == null) {
			throw new NotFoundException("The song with id= " + trackId + " was not found");
		}
		return song;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addTrack(@Context UriInfo uriInfo, Track track) {
		if(track.getTitle() == null || "".equals(track.getTitle())) {
			throw new BadRequestException("The title of the song must not be null.");
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
		Track oldSong = repository.getTrack(track.getId());
		
		if(oldSong == null) {
			throw new NotFoundException("The song with id= " + track.getId() + " was not found");
		}
		
		if(track.getTitle() != null) {
			oldSong.setTitle(track.getTitle());
		}
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeTrack(@PathParam("id") String trackId) {
		Track oldSong = repository.getTrack(trackId);
		
		if(oldSong == null) {
			throw new NotFoundException("The song with id= " + trackId + " was not found");
		}
		
		repository.deleteTrack(trackId);
		
		return Response.noContent().build();
	}
	
}
