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
import aiss.model.repository.MapPlaylistRepository;
import aiss.model.repository.PlaylistRepository;


@Path("/lists")
public class PlaylistResource {
	
	/* Singleton */
	private static PlaylistResource _instance=null;
	PlaylistRepository repository;
	
	private PlaylistResource() {
		repository=MapPlaylistRepository.getInstance();

	}
	
	public static PlaylistResource getInstance()
	{
		if(_instance==null)
				_instance=new PlaylistResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Playlist> getAll()
	{
		return repository.getAllPlaylists();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Playlist get(@PathParam("id") String id)
	{
		Playlist list = repository.getPlaylist(id);
		
		if (list == null) {
			throw new NotFoundException("The playlist wit id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlaylist(@Context UriInfo uriInfo, Playlist playlist) {
		if (playlist.getName() == null || "".equals(playlist.getName()))
			throw new BadRequestException("The name of the playlist must not be null");
		
		if (playlist.getTracks()!=null)
			throw new BadRequestException("The songs property is not editable.");

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
			throw new NotFoundException("The playlist with id="+ playlist.getId() +" was not found");			
		}
		
		if (playlist.getTracks()!=null)
			throw new BadRequestException("The songs property is not editable.");
		
		// Update name
		if (playlist.getName()!=null)
			oldplaylist.setName(playlist.getName());
		
		// Update description
		if (playlist.getDescription()!=null)
			oldplaylist.setDescription(playlist.getDescription());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removePlaylist(@PathParam("id") String id) {
		Playlist toberemoved=repository.getPlaylist(id);
		if (toberemoved == null)
			throw new NotFoundException("The playlist with id="+ id +" was not found");
		else
			repository.deletePlaylist(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{playlistId}/{songId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo,@PathParam("playlistId") String playlistId, @PathParam("trackId") String trackId)
	{				
		
		Playlist playlist = repository.getPlaylist(playlistId);
		Track song = repository.getTrack(trackId);
		
		if (playlist==null)
			throw new NotFoundException("The playlist with id=" + playlistId + " was not found");
		
		if (song == null)
			throw new NotFoundException("The song with id=" + trackId + " was not found");
		
		if (playlist.getSong(trackId)!=null)
			throw new BadRequestException("The song is already included in the playlist.");
			
		repository.addTrack(playlistId, trackId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(playlistId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(playlist);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{playlistId}/{songId}")
	public Response removeSong(@PathParam("playlistId") String playlistId, @PathParam("trackId") String trackId) {
		Playlist playlist = repository.getPlaylist(playlistId);
		Track song = repository.getTrack(trackId);
		
		if (playlist==null)
			throw new NotFoundException("The playlist with id=" + playlistId + " was not found");
		
		if (song == null)
			throw new NotFoundException("The song with id=" + trackId + " was not found");
		
		
		repository.removeTrack(playlistId, trackId);		
		
		return Response.noContent().build();
	}
}
