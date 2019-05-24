package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.deezer.PlayListData;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.deezer.TrackSearch;
import aiss.model.deezer.User;
import aiss.model.youtube.Items;
import aiss.model.youtube.Response;

public class VideosResource {

	private static String ACCES_TOKEN;
	private static final String API_KEY = "LB9Xc8zkjIsN7T94slzpz5Vs";
	private static String URI_BASICA = "https://www.googleapis.com/youtube/v3/";
	private static String URI_PLAYLISTS = URI_BASICA + "search/playlist?q=";
	private static final Logger log = Logger.getLogger(VideosResource.class.getName());
	
	
	public VideosResource(String token) {
		super();
		ACCES_TOKEN = token;
	}
	
	
	public Response getPlayLists() throws UnsupportedEncodingException {
		
		String uri = URI_PLAYLISTS + "playlists?part=snippet%2CcontentDetails&mine=true&key=" + API_KEY;
		log.log(Level.FINE, "Youtube URI: " + uri);
		
		ClientResource cr = null;
		Response resp = null;
		try {
			cr = new ClientResource(uri);
			resp = cr.get(Response.class);
			log.log(Level.FINE, "Youtube Response: " + Arrays.asList(resp));
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the playlists: " + cr.getResponse().getStatus());
		}
	    return resp;
	}
	
	public static String getPlaylistId(Response resp) throws UnsupportedEncodingException {
		String id = "";
		List<Items> playlists = new ArrayList<E>();
	    return id;
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
	public String getUserId() throws UnsupportedEncodingException{
		String id = "";
		String userUri = URI_BASICA + "user/me";
		 ClientResource cr = new ClientResource(userUri);

	        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);

	        log.info("Retrieving user profile");

	        try {
	            return cr.get(User.class).getId();

	        } catch (ResourceException re) {
	            log.warning("Error when retrieving the user profile: " + cr.getResponse().getStatus());
	            log.warning(userUri);
	            return null;
	        }
	    }
	public Boolean addTracksFavorite(String userId, String trackId) throws UnsupportedEncodingException{
		Boolean res = true;
	    ClientResource cr = new ClientResource(URI_BASICA + "user/" + userId + "/tracks/" + trackId);
        try {
            ChallengeResponse chr = new ChallengeResponse(
                    ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
//            StringRepresentation rep = new StringRepresentation(content, MediaType.TEXT_PLAIN);
//            cr.put(rep);
        } catch (ResourceException re) {
            log.warning("Error when adding track " + trackId + " to favourites");
            log.warning(re.getMessage());
            return false;
        }

		return res;
	}

}
