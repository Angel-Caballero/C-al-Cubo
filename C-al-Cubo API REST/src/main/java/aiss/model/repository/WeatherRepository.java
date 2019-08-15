package aiss.model.repository;

import java.util.Collection;
import aiss.model.Playlist;
import aiss.model.Track;
import aiss.model.Weather;

public interface WeatherRepository {

	//Weather
	public void addWeather(Weather w);
	public Collection<Weather> getAllWeathers();
	public Weather getWeather(String weatherId);
	public void updateWeather(Weather w);
	public void deleteWeather(String weatherId);
	public Playlist getWeatherPlaylist(String weatherId);
	public void setPlaylist(String weatherId, String playlistId);
	public void removePlaylist(String weatherId);
	public Collection<Track> getWeatherTracks(String weatherId);
//	public void addSong(String weatherId, String playlistId, String trackId);
//	public void removeSong(String weatherId, String playlistId, String trackId);
	
	//Playlist
	public void addPlaylist(Playlist p);
	public Collection<Playlist> getAllPlaylists();
	public Playlist getPlaylist(String playlistId);
	public void updatePlaylist(Playlist p);
	public void deletePlaylist(Playlist p);
	public Collection<Track> getTracks(String playlistId);
	public void addTrack(String playlistId, String trackId);
	public void removeTrack(String playlistId, String trackId);
	
	//Track
	public void addTrack(Track t);
	public Collection<Track> getAllTracks();
	public Track getTrack(String trackId);
	public void updateTrack(Track t);
	public void deleteTrack(String trackId);
}
