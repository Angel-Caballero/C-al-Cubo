package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.deezer.PlayListData;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.deezer.TrackSearch;
import aiss.model.deezer.User;
import aiss.model.youtube.Items;
import aiss.model.youtube.Response;
import aiss.model.youtube.Snippet;
import aiss.model.youtube.Status;

public class CalendarResource {
	private static String ACCES_TOKEN;
	private static final String API_KEY = "AIzaSyD_jORWq0E5wOvzIf3FgN_lIbL4rNCiRys";
	private static String URI_BASICA = "https://www.googleapis.com/calendar/v3/";
	private static final Logger log = Logger.getLogger(CalendarResource.class.getName());
	
	
	public CalendarResource(String token) {
		super();
		ACCES_TOKEN = token;
	}
	
	
	public Response getPlayLists() throws UnsupportedEncodingException {
		
		String uri = URI_BASICA + "playlists?part=snippet%2CcontentDetails&mine=true&key=" + API_KEY;
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
		List<Items> playlists = new ArrayList<>();
		playlists.addAll(Arrays.asList(resp.getItems()));
		if(resp.getNextPageToken() != null) {
			ClientResource cr = null;
			Response respAux = null;
			while(resp.getNextPageToken() != null) {
				String uri = URI_BASICA + "playlists?part=snippet%2CcontentDetails&mine=true&pageToken=" + resp.getNextPageToken() + 
						"&key=" + API_KEY;
				log.log(Level.FINE, "Youtube URI: " + uri);
				
				try {
					cr = new ClientResource(uri);
					respAux = cr.get(Response.class);
					playlists.addAll(Arrays.asList(respAux.getItems()));
					
				} catch (ResourceException re) {
					System.err.println("Error when retrieving the playlists: " + cr.getResponse().getStatus());
				}
			}
			log.log(Level.FINE, "Youtube Response: " + Arrays.asList(resp));
		}
		
		//playlists.stream().filter(i -> i.getSnippet().getTitle().equals("")).map(i -> i.getId()).findFirst().get();
	    for(int pos = 0; pos < playlists.size(); pos++) {
	    	if(playlists.get(pos).getSnippet().getTitle().equals("C al Cubo")) {
	    		id=playlists.get(pos).getId();
	    		break;
	    	}
	    }
		return id;
	}
	
	public Boolean createPlayList() throws UnsupportedEncodingException{
		Boolean res = true;
//		playlists?part=snippet%2Cstatus&key={YOUR_API_KEY}
		String uri = URI_BASICA + "playlists?part=snippet%2Cstatus&key=" + API_KEY;
		log.log(Level.FINE, "Youtube URI: " + uri);
	    ClientResource cr = new ClientResource(uri);
        try {
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(ACCES_TOKEN);
            cr.setChallengeResponse(chr);
            
            Snippet snippet = new Snippet();
            snippet.setTitle("C al Cubo");
            snippet.setDescription("C al Cubo playlist");
            Status status = new Status();
            status.setPrivacyStatus("private");
            cr.post(snippet, MediaType.APPLICATION_ALL_JSON);
            cr.post(status, MediaType.APPLICATION_ALL_JSON);
//            StringRepresentation rep = new StringRepresentation(content, MediaType.TEXT_PLAIN);
//            cr.put(rep);
        } catch (ResourceException re) {
            log.warning("Error when creating the Mashup playlist");
            log.warning(re.getMessage());
            return false;
        }

		return res;
	}
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	        chr.setRawValue(ACCES_TOKEN);
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
            chr.setRawValue(ACCES_TOKEN);
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


