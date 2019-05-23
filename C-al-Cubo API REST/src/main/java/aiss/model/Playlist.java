package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	private String id;
	private String name;
	private String description;
	private List<Track> tracks;
	
	public Playlist() {}
	
	public Playlist(String name) {
		this.name = name;
	}
	
	protected void setSongs(List<Track> s) {
		tracks = s;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Track> getTracks() {
		return tracks;
	}
	
	public Track getSong(String id) {
		if (tracks==null) {
			return null;
		}
		
		Track song =null;
		for(Track s: tracks)
			if (s.getId().equals(id))
			{
				song=s;
				break;
			}
		
		return song;
	}
	
	public void addSong(Track s) {
		if (tracks==null)
			tracks = new ArrayList<Track>();
		tracks.add(s);
	}
	
	public void deleteSong(Track s) {
		tracks.remove(s);
	}
	
	public void deleteSong(String id) {
		Track s = getSong(id);
		if (s!=null)
			tracks.remove(s);
	}

}
