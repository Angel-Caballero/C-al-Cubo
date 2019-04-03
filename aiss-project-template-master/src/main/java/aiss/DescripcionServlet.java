package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DescripcionServlet extends HttpServlet{

	private static final Logger log = Logger.getLogger(IntegrantesServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Sample log
		log.log(Level.FINE, "Processing GET request");
		 
		resp.setContentType("text/plain");
		resp.getWriter().println("Con nuestro proyecto queremos que los usuarios disfruten de determinadas listas "
				+ "de reproduccion de musica dependiendo de las condiciones climatologicas o de determinadas fechas "
				+ "especiales marcadas en el calendario.");
	}
}
