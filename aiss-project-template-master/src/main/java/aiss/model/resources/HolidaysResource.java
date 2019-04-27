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

public class HolidaysResource {

	private static String URI = "https://calendarific.com/api/v2/holidays?";
	private static String API_KEY = "e34ba387d728bc9df729b505e2d6ea74588392c9";
	private static final Logger log = Logger.getLogger(HolidaysResource.class.getName());
	
	public Calendarific getHolidays(String qCountry) throws UnsupportedEncodingException {
		String country = URLEncoder.encode(qCountry, "UTF-8");
		String year = URLEncoder.encode(Year.now().toString(), "UTF-8");
		String uri = URI + "country=" + country + "&year=" + year + "&api_key=" + API_KEY;
		log.log(Level.FINE, "Calendarific URI: " + uri);
		
		ClientResource cr = null;
		Calendarific holidays = null;
	//	try {
			cr = new ClientResource(uri);
			holidays = cr.get(Calendarific.class);
		/*} catch (ResourceException re) {
			System.err.println("Error when retrieving the holidays: " + cr.getResponse().getStatus());
		}*/
	    return holidays;
	}
	
	
	public Holidays getClosestHoliday(Holidays[] holidays) throws UnsupportedEncodingException{
		Holidays result = null;
		List<Holidays> holidaysList = Arrays.asList(holidays);
		List<Holidays> aux = new ArrayList<Holidays>();
		aux = ActualHolidayFilter(holidaysList);
		if(!aux.isEmpty()) {
			result = aux.get(0);
		}else {
			result = ClosestHolidayFilter(holidaysList);
		}
		return result;
	}
	
	
	private Holidays ClosestHolidayFilter(List<Holidays> holidaysList) {
		List<Holidays> res = new ArrayList<Holidays>();
		for(int pos = 0; pos < holidaysList.size(); pos++) {
			if((Integer.parseInt(holidaysList.get(pos).getDate().getDatetime().getDay()) > MonthDay.now().getDayOfMonth()) && 
					(Integer.parseInt(holidaysList.get(pos).getDate().getDatetime().getMonth()) >= LocalDate.now().getMonth().getValue())) {
				res.add(holidaysList.get(pos));
			}
		}
		return res.get(0);
	}


	private List<Holidays> ActualHolidayFilter(List<Holidays> holidaysList) {
		List<Holidays> res = new ArrayList<Holidays>();
		for(int pos = 0; pos < holidaysList.size(); pos++) {
			if((holidaysList.get(pos).getDate().getDatetime().getDay().equals(MonthDay.now().toString())) && 
				(Integer.parseInt(holidaysList.get(pos).getDate().getDatetime().getMonth()) == LocalDate.now().getMonth().getValue())) {
				res.add(holidaysList.get(pos));
			}
		}
		return res;
	}


	public List<Holidays> getHolidaysInActualMonth(Holidays[] holidays) throws UnsupportedEncodingException {
		List<Holidays> holidaysList = Arrays.asList(holidays);
		List<Holidays> result = new ArrayList<Holidays>();
		result = ActualMonthHolidayFilter(holidaysList);
		if(result.isEmpty()) {
			System.err.println("There are no holidays in this month");
		}
		return result;
	}


	private List<Holidays> ActualMonthHolidayFilter(List<Holidays> holidaysList) {
		List<Holidays> res = new ArrayList<Holidays>();
		for(int pos = 0; pos < holidaysList.size(); pos++) {
			if(Integer.parseInt(holidaysList.get(pos).getDate().getDatetime().getMonth()) == LocalDate.now().getMonth().getValue()) {
				res.add(holidaysList.get(pos));
			}
		}
		return res;
	}
	
}
