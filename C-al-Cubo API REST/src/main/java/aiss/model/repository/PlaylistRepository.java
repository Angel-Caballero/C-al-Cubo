package aiss.model.repository;

import java.util.Collection;
import aiss.model.Playlist;
import aiss.model.Track;
import aiss.model.Weather;

public interface PlaylistRepository {
	
	
	//Weather
	public void addWeather(Weather w);
	public Collection<Weather> getAllWeather();
	public Track getWeather(String weatherId);
	public void updateWeather(Weather w);
	public void deleteWeather(String weatherId);
	
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
