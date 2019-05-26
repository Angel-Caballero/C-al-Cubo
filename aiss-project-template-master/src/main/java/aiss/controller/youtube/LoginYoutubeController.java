package aiss.controller.youtube;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.resources.VideosResource;

public class LoginYoutubeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginYoutubeController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginYoutubeController() {
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
    		VideosResource vr = new VideosResource(accessToken);
    		Boolean booleano = vr.createPlayList();
    		if(booleano) {
    			rd = request.getRequestDispatcher("/index.html");
    		}else {
    			log.log(Level.SEVERE, "No se pudo crear la lista de reproduccion");
    			rd = request.getRequestDispatcher("/error.jsp");
    		}
 
    	}
    	else {
    		log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
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
