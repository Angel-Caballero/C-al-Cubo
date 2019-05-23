package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ls.LSOutput;

import aiss.model.Playlist;
import aiss.model.Track;
import aiss.model.Weather;


public class MapPlaylistRepository implements PlaylistRepository{

	Map<String, Weather> weatherMap;
	Map<String, Playlist> playlistMap;
	Map<String, Track> songMap;
	private static MapPlaylistRepository instance=null;
	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapPlaylistRepository getInstance() {
		
		if (instance==null) {
			instance = new MapPlaylistRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		playlistMap = new HashMap<String,Playlist>();
		songMap = new HashMap<String,Track>();
		
		// Create songs
		Track rollingInTheDeep=new Track();
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
		
		Track losingMyReligion=new Track();
		losingMyReligion.setTitle("Losing my Religion");
		losingMyReligion.setArtist("REM");
		losingMyReligion.setYear("1991");
		losingMyReligion.setAlbum("Out of Time");
		addTrack(losingMyReligion);
		
		Track smellLikeTeenSpirit=new Track();
		smellLikeTeenSpirit.setTitle("Smell Like Teen Spirit");
		smellLikeTeenSpirit.setArtist("Nirvana");
		smellLikeTeenSpirit.setAlbum("Nevermind");
		smellLikeTeenSpirit.setYear("1991");
		addTrack(smellLikeTeenSpirit);
		
		Track gotye=new Track();
		gotye.setTitle("Someone that I used to know");
		gotye.setArtist("Gotye");
		gotye.setYear("2011");
		gotye.setAlbum("Making Mirrors");
		addTrack(gotye);
		
		// Create playlists
		Playlist japlaylist=new Playlist();
		japlaylist.setName("AISSPlayList");
		japlaylist.setDescription("AISS PlayList");
		addPlaylist(japlaylist);
		
		Playlist playlist = new Playlist();
		playlist.setName("Favourites");
		playlist.setDescription("A sample playlist");
		addPlaylist(playlist);
		
		// Add songs to playlists
		addTrack(japlaylist.getId(), rollingInTheDeep.getId());
		addTrack(japlaylist.getId(), one.getId());
		addTrack(japlaylist.getId(), smellLikeTeenSpirit.getId());
		addTrack(japlaylist.getId(), losingMyReligion.getId());
		
		addTrack(playlist.getId(), losingMyReligion.getId());
		addTrack(playlist.getId(), gotye.getId());
	}
	
	// Playlist related operations
	@Override
	public void addPlaylist(Playlist p) {
		String id = "p" + index++;	
		p.setId(id);
		playlistMap.put(id,p);
	}
	
	@Override
	public Collection<Playlist> getAllPlaylists() {
			return playlistMap.values();
	}

	@Override
	public Playlist getPlaylist(String id) {
		return playlistMap.get(id);
	}
	
	@Override
	public void updatePlaylist(Playlist p) {
		playlistMap.put(p.getId(),p);
	}

	@Override
	public void deletePlaylist(String id) {	
		playlistMap.remove(id);
	}
	

	@Override
	public void addTrack(String playlistId, String trackId) {
		Playlist playlist = getPlaylist(playlistId);
		playlist.addSong(songMap.get(trackId));
	}

	@Override
	public Collection<Track> getAll(String playlistId) {
		return getPlaylist(playlistId).getTracks();
	}

	@Override
	public void removeTrack(String playlistId, String trackId) {
		getPlaylist(playlistId).deleteSong(trackId);
	}

	
	// Song related operations
	
	@Override
	public void addTrack(Track t) {
		String id = "s" + index++;
		t.setId(id);
		songMap.put(id, t);
	}
	
	@Override
	public Collection<Track> getAllTracks() {
			return songMap.values();
	}

	@Override
	public Track getTrack(String trackId) {
		return songMap.get(trackId);
	}

	@Override
	public void updateTrack(Track t) {
		Track song = songMap.get(t.getId());
		song.setTitle(t.getTitle());
		song.setAlbum(t.getAlbum());
		song.setArtist(t.getArtist());
		song.setYear(t.getYear());
	}

	@Override
	public void deleteTrack(String trackId) {
		songMap.remove(trackId);
	}

	
	//Weather Related
	@Override
	public void addWeather(Weather w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Weather> getAllWeather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Track getWeather(String weatherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWeather(Weather w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWeather(String weatherId) {
		// TODO Auto-generated method stub
		
	}
	
}
