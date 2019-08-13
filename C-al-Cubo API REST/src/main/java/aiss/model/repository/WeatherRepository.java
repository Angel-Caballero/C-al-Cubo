package aiss.model.repository;

import java.util.Collection;
import aiss.model.Playlist;
import aiss.model.Weather;

public interface WeatherRepository {

	//Weather
	public void addWeather(Weather w);
	public Collection<Weather> getAllWeathers();
	public Weather getWeather(String weatherId);
	public void updateWeather(Weather w);
	public void deleteWeather(String weatherId);
	public Playlist getWeatherPlaylist(String weatherId, String playlistId);
	public void addPlaylist(String weatherId, String playlistId);
	public void removePlaylist(String weatherId, String playlistId);
	
}
