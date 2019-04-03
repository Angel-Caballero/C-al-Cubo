package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntegrantesServlet extends HttpServlet{

	private static final Logger log = Logger.getLogger(IntegrantesServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Sample log
		log.log(Level.FINE, "Processing GET request");
		 
		resp.setContentType("text/plain");
		resp.getWriter().println("Angel Caballero Dominguez");
		resp.getWriter().println("Jaime Cañada Arjona");
		resp.getWriter().println("Pablo Colmenero Capote");
	}
}
