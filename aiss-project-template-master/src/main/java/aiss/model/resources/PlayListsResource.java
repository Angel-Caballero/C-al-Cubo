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

public class PlayListsResource {
	
	private static String URI = "https://api.deezer.com/playlist/";
	private static final Logger log = Logger.getLogger(PlayListsResource.class.getName());
	
	public Calendarific getHolidays(String query) throws UnsupportedEncodingException {
		
		String titulo = URLEncoder.encode(query, "UTF-8");
		String uri = URI + "country=" + country + "&year=" + year + "&api_key=" + API_KEY;
		log.log(Level.FINE, "Deezer URI: " + uri);
		
		ClientResource cr = null;
		Calendarific holidays = null;
		try {
			cr = new ClientResource(uri);
			holidays = cr.get(Calendarific.class);
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the holidays: " + cr.getResponse().getStatus());
		}
	    return holidays;
	}
	
	
	public Holidays getClosestHoliday(Holidays[] holidays) throws UnsupportedEncodingException{
		Holidays result = null;
		List<Holidays> holidaysList = Arrays.asList(holidays);
		List<Holidays> aux = new ArrayList<Holidays>();
		aux = holidaysList.stream().filter(h -> (h.getDate().getDatetime().getDay().equals(MonthDay.now().toString())) && 
				(Integer.parseInt(h.getDate().getDatetime().getMonth()) == LocalDate.now().getMonth().getValue()))
				.collect(Collectors.toList());
		if(!aux.isEmpty()) {
			result = aux.get(0);
		}else {
			result = holidaysList.stream().filter(h -> (Integer.parseInt(h.getDate().getDatetime().getDay()) > MonthDay.now().getDayOfMonth()) && 
					(Integer.parseInt(h.getDate().getDatetime().getMonth()) >= LocalDate.now().getMonth().getValue())).findFirst().get();
		}
		return result;
	}
	
	
	public List<Holidays> getHolidaysInActualMonth(Holidays[] holidays) throws UnsupportedEncodingException {
		List<Holidays> holidaysList = Arrays.asList(holidays);
		List<Holidays> result = new ArrayList<Holidays>();
		result = holidaysList.stream().filter(h -> Integer.parseInt(h.getDate().getDatetime().getMonth()) == LocalDate.now().getMonth().getValue())
				.collect(Collectors.toList());
		if(result.isEmpty()) {
			System.err.println("There are no holidays in this month");
		}
		return result;
	}
}
