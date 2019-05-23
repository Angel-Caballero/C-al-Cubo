package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Weather {
	
	private String id;
	private String name;
	private List<Playlist> playlists;
	
	public Weather(){
		super();
		playlists = new ArrayList<Playlist>();
	}
	
	public Weather(String id, String name){
		this.id = id;
		this.name = name;
		playlists = new ArrayList<Playlist>();
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

	public Playlist getPlaylist(String id) {
		if (playlists==null) {
			return null;
		}
		Playlist list =null;
		for(Playlist p: playlists) {
			if (p.getId().equals(id)){
				list=p;
				break;
			}
		}	
		return list;
	}
	
	public void addPlaylist(Playlist p) {
		if (playlists==null) {
			playlists.add(p);
		}
	}
	
	public void deleteSong(Playlist p) {
		playlists.remove(p);
	}
	
	public void deleteSong(String id) {
		Playlist p = getPlaylist(id);
		if (p!=null)
			playlists.remove(p);
	}
	
	
	
}
