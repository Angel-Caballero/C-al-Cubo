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
	public Playlist getWeatherPlaylist(String weatherId) {
		return getWeather(weatherId).getPlaylist();
	}


	@Override
	public void setPlaylist(String weatherId, String playlistId) {
		Weather w = getWeather(weatherId);
		w.setPlaylist(playlistMap.get(playlistId));
	}
	
	
	@Override
	public void removePlaylist(String weatherId) {
		Weather w = getWeather(weatherId);
		w.setPlaylist(null);
	}


	@Override
	public Collection<Track> getWeatherTracks(String weatherId) {
		return getWeatherPlaylist(weatherId).getTracks();
	}

	
//	@Override
//	public void addSong(String weatherId, String playlistId, String trackId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public void removeSong(String weatherId, String playlistId, String trackId) {
//		// TODO Auto-generated method stub
//		
//	}


	//Methods related to playlist
	@Override
	public void addPlaylist(Playlist p) {
		String id = "p" + index++;
		p.setId(id);
		playlistMap.put(id, p);
	}


	@Override
	public Collection<Playlist> getAllPlaylists() {
		return playlistMap.values();
	}


	@Override
	public Playlist getPlaylist(String playlistId) {
		return playlistMap.get(playlistId);
	}


	@Override
	public void updatePlaylist(Playlist p) {
		playlistMap.put(p.getId(), p);
	}


	@Override
	public void deletePlaylist(Playlist p) {
		playlistMap.remove(p.getId());
	}


	@Override
	public Collection<Track> getTracks(String playlistId) {
		return getPlaylist(playlistId).getTracks();
	}


	@Override
	public void addTrack(String playlistId, String trackId) {
		Playlist p = getPlaylist(playlistId);
		p.addTrack(trackMap.get(trackId));
	}


	@Override
	public void removeTrack(String playlistId, String trackId) {
		Playlist p = getPlaylist(playlistId);
		p.deleteTrack(trackMap.get(trackId));
	}


	//Methods related to playlist
	@Override
	public void addTrack(Track t) {
		String id = "t" + index++;
		t.setId(id);
		trackMap.put(id, t);
	}


	@Override
	public Collection<Track> getAllTracks() {
		return trackMap.values();
	}


	@Override
	public Track getTrack(String trackId) {
		return trackMap.get(trackId);
	}


	@Override
	public void updateTrack(Track t) {
		Track track = trackMap.get(t.getId());
		track.setAlbum(t.getAlbum());
		track.setArtist(t.getArtist());
		track.setTitle(t.getTitle());
		track.setYear(t.getYear());
	}


	@Override
	public void deleteTrack(String trackId) {
		trackMap.remove(trackId);	
	}

}
