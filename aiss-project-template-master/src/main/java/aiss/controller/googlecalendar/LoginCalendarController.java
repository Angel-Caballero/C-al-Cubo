package aiss.controller.googlecalendar;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.CalendarResource;

public class LoginCalendarController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginCalendarController.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCalendarController() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accessToken = (String) request.getSession().getAttribute("GoogleCalendar-token");

		// Request data
		RequestDispatcher rd = null;


		if (accessToken != null && !"".equals(accessToken)) {
			CalendarResource cr = new CalendarResource(accessToken);
			if(!cr.existsCalendar()) {
				cr.createCalendar();
			}
			rd = request.getRequestDispatcher("/index.html");

		}
		else {
			log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
			rd = request.getRequestDispatcher("/AuthController/GoogleCalendar");
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


