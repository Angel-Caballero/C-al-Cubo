package aiss.controller.deezer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.controller.calendarific.HolidaysController;
import aiss.model.resources.PlayListsResource;

public class FavouriteMusicController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(HolidaysController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavouriteMusicController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute("Deezer-token");
		// Request data
		String trackId = request.getParameter("trackId");
		
		//Comprobamos que el token que se nos devuelve no sea null ni vacio
		if (accessToken != null && !"".equals(accessToken)) {
			PlayListsResource plr =new PlayListsResource(accessToken);
			String userId = plr.getUserId();
			//Comprobamos que la id de usuario no es nula ni vacia 
			if(userId != null && userId.equals("")) {
				plr.addTracksFavorite(userId, trackId);
//				String city = request.getParameter("city");
//				String country = request.getParameter("country");
				
				
				request.getRequestDispatcher("/index.html").forward(request, response);
			}
			//Caso de que la id de usuario sea nula o vacia
			else {
				log.info("There is a problem with the user id, redirecting to OAuth servlet");
	            request.getRequestDispatcher("/AuthController/Deezer").forward(request, response);
			}
		}
		//Caso de que el token sea null o vacio
		else {
			log.info("Trying to access Google Drive without an access token, redirecting to OAuth servlet");
            request.getRequestDispatcher("/AuthController/Deezer").forward(request, response);
		}
	}
}
