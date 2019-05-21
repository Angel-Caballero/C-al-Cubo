package aiss.controller.deezer;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.controller.calendarific.HolidaysController;
import aiss.model.deezer.PlayListSearch;
import aiss.model.deezer.TrackData;
import aiss.model.resources.PlayListsResource;



/**
 * Servlet implementation class PlaylistController
 */
public class PlaylistController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(HolidaysController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accessToken = (String) request.getSession().getAttribute("Deezer-token");

		// Request data
		String query = request.getParameter("query");
		RequestDispatcher rd = null;


		if (accessToken != null && !"".equals(accessToken)) {
			// Search for PlayLists
			PlayListsResource plr = new PlayListsResource(accessToken);
			PlayListSearch busquedaPlayList = plr.getPlayLists(query);

			if (busquedaPlayList != null) {
				log.log(Level.FINE, "Retrieved playlists with the search query '" + query + "' succesfully");
				List<TrackData> busquedaTracks = plr.getTracks(busquedaPlayList);

				log.log(Level.FINE, "Retrieved tracks from the playlist succesfully");
				request.setAttribute("tracks", busquedaTracks);
				rd = request.getRequestDispatcher("/deezer.jsp");
				request.setAttribute("playlist", PlayListsResource.getFirstPlayList(busquedaPlayList));

			}
			else {
				log.log(Level.SEVERE, "Could not retrieve playlists with the search query " + query + " succesfully");
				rd = request.getRequestDispatcher("/error.jsp");
			}
		}else {
			log.info("Trying to access Drive without an access token, redirecting to OAuth servlet");
			rd = request.getRequestDispatcher("/AuthController/Deezer");
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
