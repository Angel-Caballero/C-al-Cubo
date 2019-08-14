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
	public Collection<Playlist> getWeatherPlaylists(String weatherId);
	public void addPlaylist(String weatherId, String playlistId);
	public void removePlaylist(String weatherId, String playlistId);
	public Collection<Track> getWeatherTracks(String weatherId, String playlistId);
	public void addSong(String weatherId, String playlistId, String trackId);
	public void removeSong(String weatherId, String playlistId, String trackId);
}
