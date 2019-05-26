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
import aiss.model.calendarific.Holidays;
import aiss.model.googlecalendar.CalendarListResponse;
import aiss.model.googlecalendar.End;
import aiss.model.googlecalendar.Items;
import aiss.model.googlecalendar.RequestCalendar;
import aiss.model.googlecalendar.RequestEvent;
import aiss.model.googlecalendar.Start;

public class CalendarResource {
	private static String ACCES_TOKEN;
	private static final String API_KEY = "AIzaSyD_jORWq0E5wOvzIf3FgN_lIbL4rNCiRys";
	private static String URI_BASICA = "https://www.googleapis.com/calendar/v3/";
	private static final Logger log = Logger.getLogger(CalendarResource.class.getName());
	
	
	public CalendarResource(String token) {
		super();
		ACCES_TOKEN = token;
	}
	
	
	private List<Items> getCalendarList() throws UnsupportedEncodingException {
		
//		https://www.googleapis.com/calendar/v3/users/me/calendarList?key={YOUR_API_KEY}
//		https://www.googleapis.com/calendar/v3/users/me/calendarList?pageToken=54&key={YOUR_API_KEY}
		String uri = URI_BASICA + "users/me/calendarList?key=" + API_KEY;
		log.log(Level.FINE, "Google Calendar URI: " + uri);
		
		ClientResource cr = null;
		CalendarListResponse response = null;
		List<Items> res = new ArrayList<>();
		try {
			cr = new ClientResource(uri);
			response = cr.get(CalendarListResponse.class);
			res.addAll(Arrays.asList(response.getItems()));
			if(response.getNextPageToken() != null) {
				String uri2 = "";
				while (response.getNextPageToken() != null) {
					uri2 = URI_BASICA + "users/me/calendarList?pageToken=" + response.getNextPageToken() + "&key=" + API_KEY;
					cr = new ClientResource(uri2);
					response = cr.get(CalendarListResponse.class);
					res.addAll(Arrays.asList(response.getItems()));
				}
			}
			log.log(Level.FINE, "Calendar Lists: " + res);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the calendar lists: " + cr.getResponse().getStatus());
		}
	    return res;
	}
	
	public Boolean existsCalendar() throws UnsupportedEncodingException{
		Boolean res = null;
		String id = "";
		List<Items> calendars = new ArrayList<Items>();
		Items calendar = null;
		for(int pos = 0; pos<getCalendarList().size(); pos++) {
			calendar = calendars.get(pos);
			if(calendar.getSummary().equals("C al Cubo")) {
				id = calendar.getId();
				break;
			}
		}
		
		if(id.equals("")) {
			res = false;
		}else {
			res = true;
		}


		return res;
	}
	
	
	public String getCalendarId() throws UnsupportedEncodingException{
		String res = "";
		List<Items> calendars = new ArrayList<Items>();
		Items calendar = null;
		for(int pos = 0; pos<getCalendarList().size(); pos++) {
			calendar = calendars.get(pos);
			if(calendar.getSummary().equals("C al Cubo")) {
				res = calendar.getId();
				break;
			}
		}

		return res;
	}

	
	public void createCalendar() throws UnsupportedEncodingException{
		if(!existsCalendar()) {
			//https://www.googleapis.com/calendar/v3/calendars?key={YOUR_API_KEY}
			String uri = URI_BASICA + "calendars?key=" + API_KEY;
			log.log(Level.FINE, "Google Calendar URI: " + uri);
			ClientResource cr = new ClientResource(uri);
			try {
				ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
				chr.setRawValue(ACCES_TOKEN);
				cr.setChallengeResponse(chr);

				RequestCalendar body = new RequestCalendar();
				body.setSummary("C al Cubo");
				body.setDescription("Calendario de los eventos favoritos del Mahsup de C al Cubo");
				cr.post(body, MediaType.APPLICATION_ALL_JSON);
				//StringRepresentation rep = new StringRepresentation(content, MediaType.TEXT_PLAIN);
				//cr.put(rep);
			} catch (ResourceException re) {
				log.warning("Error when creating the Mashup Calendar");
				log.warning(re.getMessage());
			}
		}
	}
	
	public Boolean createEvent(String calendarId, Holidays holiday) throws UnsupportedEncodingException{
		Boolean res = null;
//		https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events?key={YOUR_API_KEY}
		String uri = URI_BASICA + "calendars/" + calendarId + "/events?key=" + API_KEY;
		log.log(Level.FINE, "Google Calendar URI: " + uri);
	    ClientResource cr = new ClientResource(uri);
        try {
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(ACCES_TOKEN);
            cr.setChallengeResponse(chr);
            
            RequestEvent body = new RequestEvent();
            body.setSummary(holiday.getName());
            body.setDescription(holiday.getDescription());
            Start start = new Start();
            start.setDate(holiday.getDate().getIso());
            End end = new End();
            end.setDate(holiday.getDate().getIso());
            cr.post(body, MediaType.APPLICATION_ALL_JSON);
//            StringRepresentation rep = new StringRepresentation(content, MediaType.TEXT_PLAIN);
//            cr.put(rep);
            res = true;
        } catch (ResourceException re) {
            log.warning("Error when creating the Mashup Event");
            log.warning(re.getMessage());
            res = false;
        }

		return res;
	}
}


