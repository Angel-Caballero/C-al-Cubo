package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	private String id;
	private String name;
	private List<Track> tracks;
	
	
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
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	
	public Track getTrack(String id) {
		if(tracks == null) {
			return null;
		}
		
		Track track = null;
		for(Track t : tracks) {
			if(t.getId().equals(id)) {
				track = t;
				break;
			}
		}
		return track;
	}
	
	public void addTrack(Track t) {
		if(tracks == null) {
			tracks = new ArrayList<Track>();
		}
		tracks.add(t);
	}
	
	public void deleteTrack(Track t) {
		tracks.remove(t);
	}
	
	public void deleteTrack(String trackId) {
		Track t = getTrack(id);
		if(t != null) {
			deleteTrack(t);
		}
	}
}
