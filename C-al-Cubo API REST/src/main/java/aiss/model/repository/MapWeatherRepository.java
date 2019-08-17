package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
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
		weatherMap = new HashMap<String,Weather>();
		playlistMap = new HashMap<String,Playlist>();
		trackMap = new HashMap<String,Track>();
		
		// Create songs
		Track rollingInTheDeep = new Track();
		rollingInTheDeep.setTitle("Rolling in the Deep");
		rollingInTheDeep.setArtist("Adele");
		rollingInTheDeep.setYear("2011");
		rollingInTheDeep.setAlbum("21");
		addTrack(rollingInTheDeep);
		
		Track one=new Track();
		one.setTitle("One");
		one.setArtist("U2");
		one.setYear("1992");
		one.setAlbum("Achtung Baby");
		addTrack(one);
		
		Track losingMyReligion = new Track();
		losingMyReligion.setTitle("Losing my Religion");
		losingMyReligion.setArtist("REM");
		losingMyReligion.setYear("1991");
		losingMyReligion.setAlbum("Out of Time");
		addTrack(losingMyReligion);
		
		Track smellLikeTeenSpirit = new Track();
		smellLikeTeenSpirit.setTitle("Smell Like Teen Spirit");
		smellLikeTeenSpirit.setArtist("Nirvana");
		smellLikeTeenSpirit.setAlbum("Nevermind");
		smellLikeTeenSpirit.setYear("1991");
		addTrack(smellLikeTeenSpirit);
		
		Track gotye = new Track();
		gotye.setTitle("Someone that I used to know");
		gotye.setArtist("Gotye");
		gotye.setYear("2011");
		gotye.setAlbum("Making Mirrors");
		addTrack(gotye);
		
		// Create playlists
		Playlist japlaylist=new Playlist();
		japlaylist.setName("AISSPlayList");
		addPlaylist(japlaylist);
		
		Playlist playlist = new Playlist();
		playlist.setName("Favourites");
		addPlaylist(playlist);
		
		// Create weathers
		Weather cloudy = new Weather();
		cloudy.setName("Cloudy");
		
		Weather sunny = new Weather();
		sunny.setName("Sunny");
		
		// Add songs to playlists
		addTrack(japlaylist.getId(), rollingInTheDeep.getId());
		addTrack(japlaylist.getId(), one.getId());
		addTrack(japlaylist.getId(), smellLikeTeenSpirit.getId());
		addTrack(japlaylist.getId(), losingMyReligion.getId());
		
		addTrack(playlist.getId(), losingMyReligion.getId());
		addTrack(playlist.getId(), gotye.getId());
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
