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
import aiss.model.resources.TracksResource;



/**
 * Servlet implementation class PlaylistController
 */
public class PlaylistController {

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
	
		// Request data
		String query = request.getParameter("query");
		RequestDispatcher rd = null;
				
		// Search for PlayLists
		PlayListsResource plr = new PlayListsResource();
		PlayListSearch busquedaPlayList = plr.getPlayLists(query);
		
		if (busquedaPlayList != null) {
			log.log(Level.FINE, "Retrieved playlists with the search query " + query + " succesfully");
			TracksResource tr = new TracksResource();
			List<TrackData> busquedaTracks = tr.getTracks(busquedaPlayList);
			
			if (busquedaTracks.isEmpty()) {
				log.log(Level.FINE, "Retrieved tracks from the playlist succesfully");
				request.setAttribute("tracks", busquedaTracks);
				rd = request.getRequestDispatcher("/deezer.jsp");
				request.setAttribute("playlist", PlayListsResource.getFirstPlayList(busquedaPlayList));
			}
			else {
				log.log(Level.SEVERE, "Could not retrieve tracks from the playlist");
				rd = request.getRequestDispatcher("/error.jsp");
			}
		}
		else {
			log.log(Level.SEVERE, "Could not retrieve playlists with the search query " + query + " succesfully");
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
