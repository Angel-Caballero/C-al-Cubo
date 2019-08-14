package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Weather {

	private String id;
	private String name;
	private List<Playlist> playlists;
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	//Methods for the playlists inside each weather
	public Playlist getPlaylist(String id) {
		if(playlists == null) {
			return null;
		}
		
		Playlist playlist = null;
		for(Playlist p : playlists) {
			if(p.getId().equals(id)) {
				playlist = p;
				break;
			}
		}
		return playlist;
	}
	
	public void addPlaylist(Playlist p) {
		if(playlists == null) {
			playlists  = new ArrayList<Playlist>();
		}
		playlists.add(p);
	}
	
	public void deletePlaylist(Playlist p) {
		playlists.remove(p);
		
	}
	
	public void deletePlaylist(String id) {
		Playlist p = getPlaylist(id);
		if(p != null) {
			deletePlaylist(p);
		}
	}
	
}
