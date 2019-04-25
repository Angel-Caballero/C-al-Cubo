package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import aiss.model.deezer.PlayListData;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackSearch;

public class TrackResource {

	private static final Logger log = Logger.getLogger(PlayListsResource.class.getName());
	
	public TrackSearch getTracks(PlayListSearch busqPlayList) throws UnsupportedEncodingException {
		PlayListData playList= PlayListsResource.getFirstPlayList(busqPlayList);
		String uri = playList.getTracklist();
		log.log(Level.FINE, "Deezer URI: " + uri);
		
		ClientResource cr = null;
		TrackSearch search = null;
		try {
			cr = new ClientResource(uri);
			search = cr.get(TrackSearch.class);
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the playlists: " + cr.getResponse().getStatus());
		}
	    return search;
	}

}
