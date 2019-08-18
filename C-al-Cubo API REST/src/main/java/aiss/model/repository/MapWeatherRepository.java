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
		Track gotye = new Track();
		gotye.setTitle("Someone that I used to know");
		gotye.setArtist("Gotye");
		gotye.setYear("2011");
		gotye.setAlbum("Making Mirrors");
		addTrack(gotye);
		
		Track comeTogether = new Track();
		comeTogether.setTitle("Come Together");
		comeTogether.setArtist("The Beatles");
		comeTogether.setYear("1969");
		comeTogether.setAlbum("Abbey Road");
		addTrack(comeTogether);
		
		Track bohemianRhapsody = new Track();
		bohemianRhapsody.setTitle("Bohemian Rhapsody");
		bohemianRhapsody.setArtist("Queen");
		bohemianRhapsody.setYear("1975");
		bohemianRhapsody.setAlbum("A Night at the Opera");
		addTrack(bohemianRhapsody);
		
		Track dreams = new Track();
		dreams.setTitle("Dreams");
		dreams.setArtist("Fleetwood Mac");
		dreams.setYear("1977");
		dreams.setAlbum("Rumours");
		addTrack(dreams);
		
		Track oops = new Track();
		oops.setTitle("Oops!... I Did It Again");
		oops.setArtist("Britney Spears");
		oops.setYear("2000");
		oops.setAlbum("Oops!... I Did It Again");
		addTrack(oops);
		
		Track everybody = new Track();
		everybody.setTitle("Everybody (Backstreet's Back)");
		everybody.setArtist("Backstreet Boys");
		everybody.setYear("1997");
		everybody.setAlbum("Backstreet Boys");
		addTrack(everybody);
		
		Track black = new Track();
		black.setTitle("Back In Black");
		black.setArtist("AC/DC");
		black.setYear("1980");
		black.setAlbum("Back in Black");
		addTrack(black);
		
		// Create playlists
		Playlist cAlCubo = new Playlist();
		cAlCubo.setName("C al Cubo");
		addPlaylist(cAlCubo);
		
		Playlist favourites = new Playlist();
		favourites.setName("Favourites");
		addPlaylist(favourites);
		
		Playlist sunnyD = new Playlist();
		sunnyD.setName("Sunny Days");
		addPlaylist(sunnyD);
		
		// Create weathers
		Weather cloudy = new Weather();
		cloudy.setName("Cloudy");
		addWeather(cloudy);
		
		Weather sunny = new Weather();
		sunny.setName("Sunny");
		addWeather(sunny);
		
		// Add songs to playlists
		addTrack(cAlCubo.getId(), gotye.getId());
		addTrack(cAlCubo.getId(), comeTogether.getId());
		addTrack(cAlCubo.getId(), dreams.getId());
		
		addTrack(favourites.getId(), oops.getId());
		addTrack(favourites.getId(), everybody.getId());
		addTrack(favourites.getId(), black.getId());
		
		addTrack(sunnyD.getId(), bohemianRhapsody.getId());
		
		// Sets playlists in weather
		setPlaylist(sunny.getId(), sunnyD.getId());
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
