package aiss.model.repository;

import java.util.Collection;
import java.util.Map;

import aiss.model.Playlist;
import aiss.model.Track;
import aiss.model.Weather;

public class MapWeatherRepository implements WeatherRepository{
	
	Map<String, Weather> weatherMap;
	Map<String, Playlist> playlistMap;
	Map<String, Track> trackMap;
	private static MapWeatherRepository instance = null;
	private int index = 0;
	
	
	public static MapWeatherRepository getInstance() {
		if(instance == null) {
			instance = new MapWeatherRepository();
			instance.init();
		}
		return instance;
	}


	private void init() {
		// TODO Auto-generated method stub
		
	}

	//Methods related to weather
	@Override
	public void addWeather(Weather w) {
		String id = "w" + index++;
		w.setId(id);
		weatherMap.put(id, w);
	}


	@Override
	public Collection<Weather> getAllWeathers() {
		return weatherMap.values();
	}


	@Override
	public Weather getWeather(String weatherId) {
		return weatherMap.get(weatherId);
	}


	@Override
	public void updateWeather(Weather w) {
		weatherMap.put(w.getId(), w);
	}


	@Override
	public void deleteWeather(String weatherId) {
		weatherMap.remove(weatherId);
		
	}


	@Override
	public Collection<Playlist> getWeatherPlaylists(String weatherId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addPlaylist(String weatherId, String playlistId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removePlaylist(String weatherId, String playlistId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Collection<Track> getWeatherTracks(String weatherId, String playlistId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addSong(String weatherId, String playlistId, String trackId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeSong(String weatherId, String playlistId, String trackId) {
		// TODO Auto-generated method stub
		
	}



}
