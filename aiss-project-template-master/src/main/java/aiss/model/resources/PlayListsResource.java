package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import aiss.model.calendarific.Calendarific;
import aiss.model.calendarific.Holidays;
import aiss.model.deezer.PlayListData;
import aiss.model.deezer.PlayListSearch;

public class PlayListsResource {
	
	private static String URI = "https://api.deezer.com/search/playlist?q=";
	private static final Logger log = Logger.getLogger(PlayListsResource.class.getName());
	
	public PlayListSearch getPlayLists(String query) throws UnsupportedEncodingException {
		
		String titulo = URLEncoder.encode(query, "UTF-8");
		String uri = URI + titulo;
		log.log(Level.FINE, "Deezer URI: " + uri);
		
		ClientResource cr = null;
		PlayListSearch search = null;
		try {
			cr = new ClientResource(uri);
			search = cr.get(PlayListSearch.class);
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the playlists: " + cr.getResponse().getStatus());
		}
	    return search;
	}
	
	public static PlayListData getFirstPlayList(PlayListSearch busqPlayList) throws UnsupportedEncodingException {
		List<PlayListData> playlists = Arrays.asList(busqPlayList.getData());
	    return playlists.get(0);
	}

}
