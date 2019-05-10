package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import aiss.model.deezer.PlayListData;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.deezer.TrackSearch;

public class TracksResource {

	private static final Logger log = Logger.getLogger(PlayListsResource.class.getName());
	
	public List<TrackData> getTracks(PlayListSearch busqPlayList) throws UnsupportedEncodingException {
		List<TrackData> res = new ArrayList<TrackData>();
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
			log.log(Level.FINE, "Deezer URI: " + search.getNext());
			log.log(Level.FINE, "Deezer Response: " + search);
			res.addAll(Arrays.asList(search.getData()));
		}
		
	    return res;
	}

}
