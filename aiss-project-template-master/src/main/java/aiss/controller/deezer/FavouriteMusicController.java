package aiss.controller.deezer;

import java.io.IOException;
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
		
		String trackId = request.getParameter("trackId");
		RequestDispatcher rd = null;
		
		if (accessToken != null && !"".equals(accessToken)) {
			PlayListsResource plr =new PlayListsResource(accessToken);
			String userId = plr.getUserId();
			if(userId != null) {
				plr.addTracksFavorite(userId, trackId);
				request.getRequestDispatcher("");
			}
		}
		else {
			
		}
		rd.forward(request, response);
	}
}
