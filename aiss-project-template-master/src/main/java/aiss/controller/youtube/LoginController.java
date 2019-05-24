package aiss.controller.youtube;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.resources.PlayListsResource;

public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String accessToken = (String) request.getSession().getAttribute("Youtube-token");

    	// Request data
    	RequestDispatcher rd = null;


    	if (accessToken != null && !"".equals(accessToken)) {
    		rd = request.getRequestDispatcher("/index.html");

    	}
    	else {
    		log.info("Trying to access Drive without an access token, redirecting to OAuth servlet");
    		rd = request.getRequestDispatcher("/AuthController/Youtube");
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
