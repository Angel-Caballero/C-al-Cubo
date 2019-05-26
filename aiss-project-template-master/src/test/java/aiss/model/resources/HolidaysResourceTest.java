package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.calendarific.Calendarific;

public class HolidaysResourceTest {

	static HolidaysResource hr = new HolidaysResource();
	
	@Test
	public void testGetHolidays() throws UnsupportedEncodingException {
		Calendarific calendar = hr.getHolidays("es");
		
		assertNotNull("The collection of events is null", calendar);
		
		//Show the result
		System.out.println(calendar);
	}
	
	@Test
	public void testGetMonthName() {
		assertEquals("The month is not correct", "May", hr.getMonthName());
		
		//Show Results 
		System.out.println("The actual month is: " + "May");
	}
}
