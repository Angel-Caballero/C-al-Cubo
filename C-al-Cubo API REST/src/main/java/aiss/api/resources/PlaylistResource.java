package aiss.api.resources;

import java.net.URI;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;
import aiss.model.Playlist;
import aiss.model.Track;
import aiss.model.repository.MapWeatherRepository;
import aiss.model.repository.WeatherRepository;


@Path("/playlists")
public class PlaylistResource {
	
	/* Singleton */
	private static PlaylistResource _instance=null;
	WeatherRepository repository;
	
	private PlaylistResource() {
		repository = MapWeatherRepository.getInstance();

	}
	
	public static PlaylistResource getInstance()
	{
		if(_instance==null)
				_instance=new PlaylistResource();
		return _instance;
	}
	

	//Methods related to playlists
	@GET
	@Produces("application/json")
	public Collection<Playlist> getAllPlaylists(){
		return repository.getAllPlaylists();
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlaylist(@Context UriInfo uriInfo, Playlist playlist) {
		if (playlist.getName() == null || "".equals(playlist.getName())) {
			throw new BadRequestException("The name of the playlist must not be null.");
		}
		
		if (playlist.getTracks()!=null) {
			throw new BadRequestException("The tracks property is not editable.");
		}
		
		repository.addPlaylist(playlist);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(playlist.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(playlist);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updatePlaylist(Playlist playlist) {
		Playlist oldplaylist = repository.getPlaylist(playlist.getId());
		if (oldplaylist == null) {
			throw new NotFoundException("The playlist with id="+ playlist.getId() +" was not found.");			
		}
		
		if (playlist.getTracks()!=null) {
			throw new BadRequestException("The tracks property is not editable.");
		}
		
		
		// Update name
		if (playlist.getName()!=null) {
			oldplaylist.setName(playlist.getName());
		}
		
		return Response.noContent().build();
	}
	
	
	@GET
	@Path("/{playlistId}")
	@Produces("application/json")
	public Playlist getPlaylist(@PathParam("playlistId") String id)
	{
		Playlist playlist = repository.getPlaylist(id);
		
		if (playlist == null) {
			throw new NotFoundException("The playlist wit id="+ id +" was not found.");			
		}
		
		return playlist;
	}
	


	@DELETE
	@Path("/{playlistId}")
	public Response deletePlaylist(@PathParam("playlistId") String id) {
		Playlist playlist = repository.getPlaylist(id);
		
		if (playlist == null) {
			throw new NotFoundException("The playlist with id="+ id +" was not found.");
		}else {
			repository.deletePlaylist(playlist);
		}
		
		return Response.noContent().build();
	}
	
	
	//Methods related to tracks inside the playlists
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
	public Response removeTrack(@PathParam("playlistId") String playlistId, @PathParam("trackId") String trackId) {
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
