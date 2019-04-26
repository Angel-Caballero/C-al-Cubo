package aiss.controller.calendarific;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.calendarific.Calendarific;
import aiss.model.resources.HolidaysResource;

/**
 * Servlet implementation class HolidaysController
 */
public class HolidaysController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(HolidaysController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolidaysController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String country = request.getParameter("country");
		RequestDispatcher rd = null;
				
		// Search for Holidays
		HolidaysResource hr = new HolidaysResource();
		Calendarific calendar = hr.getHolidays(country);
		
		if (calendar != null) {
			log.log(Level.FINE, "Retrieved holidays of the country " + country + " succesfully");
			rd = request.getRequestDispatcher("/holidays.jsp");
			// Solamente se pasan las vacaciones del mes actual
			request.setAttribute("holidays", hr.getHolidaysInActualMonth(calendar.getResponse().getHolidays()));
		}
		else {
			log.log(Level.SEVERE, "El calendario del pais " + country + " no tiene datos");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		
		// Forward to holidays view
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
