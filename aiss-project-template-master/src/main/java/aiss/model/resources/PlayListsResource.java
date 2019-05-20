package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import aiss.model.deezer.PlayListData;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.deezer.TrackSearch;

public class PlayListsResource {
	
	private final String access_token;
	private static String URI_PLAYLISTS = "https://api.deezer.com/search/playlist?q=";
	private static final Logger log = Logger.getLogger(PlayListsResource.class.getName());
	
	
	public PlayListsResource(String access_token) {
		super();
		this.access_token = access_token;
	}
	
	
	public PlayListSearch getPlayLists(String query) throws UnsupportedEncodingException {
		
		String titulo = URLEncoder.encode(query, "UTF-8");
		String uri = URI_PLAYLISTS + titulo;
		log.log(Level.FINE, "Deezer URI: " + uri);
		
		ClientResource cr = null;
		PlayListSearch search = null;
		try {
			cr = new ClientResource(uri);
			search = cr.get(PlayListSearch.class);
			log.log(Level.FINE, "Deezer Response: " + Arrays.asList(search.getData()));
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the playlists: " + cr.getResponse().getStatus());
		}
	    return search;
	}
	
	public static PlayListData getFirstPlayList(PlayListSearch busqPlayList) throws UnsupportedEncodingException {
		List<PlayListData> playlists = Arrays.asList(busqPlayList.getData());
	    return playlists.get(0);
	}
	
	public List<TrackData> getTracks(PlayListSearch busqPlayList) throws UnsupportedEncodingException {
		List<TrackData> res = new ArrayList<TrackData>();
		if(!Arrays.asList(busqPlayList.getData()).isEmpty()) {
			PlayListData playList= PlayListsResource.getFirstPlayList(busqPlayList);
			String uri = playList.getTracklist();
			log.log(Level.FINE, "Deezer URI: " + uri);
			
			ClientResource cr = null;
			TrackSearch search = null;
			cr = new ClientResource(uri);
			search = cr.get(TrackSearch.class);
			
			log.log(Level.FINE, "Deezer Response: " + search);
			res.addAll(Arrays.asList(search.getData()));
			
			while(search.getNext() != null) {
				cr = new ClientResource(search.getNext());
				search = cr.get(TrackSearch.class);
				log.log(Level.FINE, "Deezer Response: " + search);
				res.addAll(Arrays.asList(search.getData()));
			}
		}

	    return res;
	}
	
	
	public Boolean addTracksFavorite() {
		Boolean res = true;
		
		return res;
	}

}
