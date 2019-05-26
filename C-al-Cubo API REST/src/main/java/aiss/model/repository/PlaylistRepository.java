package aiss.model.repository;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import aiss.model.Playlist;
import aiss.model.Track;
import aiss.model.Weather;

public interface PlaylistRepository {
	
	
	//Weather
	public void addWeather(Weather w);
	public Collection<Weather> getAllWeather();
	public Weather getWeather(String weatherId);
	public void updateWeather(Weather w);
	public void deleteWeather(String weatherId);
	public List<Playlist> getWeatherPlaylists (String weather_type);
	public void updateWeatherPlaylists (String weather_type, Weather aux);
	public Response addWeatherPlaylists(List<Playlist> playlists, String weather_type);
	public Playlist getWeatherPlaylist (String weather_type, String id);
	public Response removeWeatherPlaylist(String id, String weather_type);
	public List<Track> getWeatherTracks (String weather_type);
	public Track getWeatherTrack (String weather_type, String id);
	public Response addWeatherPlaylistTrack(Track track, String weather_type, String id);
	public Response removeWeatherPlaylistTrack(String id, String weather_type, String track_id);		
	
	// Songs
	public void addTrack(Track t);
	public Collection<Track> getAllTracks();
	public Track getTrack(String trackId);
	public void updateTrack(Track t);
	public void deleteTrack(String trackId);
	
	// Playlists
	public void addPlaylist(Playlist p);
	public Collection<Playlist> getAllPlaylists();
	public Playlist getPlaylist(String playlistId);
	public void updatePlaylist(Playlist p);
	public void deletePlaylist(String playlistId);
	public Collection<Track> getAll(String playlistId);
	public void addTrack(String playlistId, String trackId);
	public void removeTrack(String playlistId, String trackId); 

	
	
	
	

}
