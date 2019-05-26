package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.deezer.PlayListSearch;

public class PlayListsResourceTest {

	static PlayListsResource plr = new PlayListsResource();
	
	@Test
	public void testGetPlayLists() throws UnsupportedEncodingException {
		PlayListSearch playlist = plr.getPlayLists("May");
		
		assertNotNull("The response of the search is null", playlist);
		
		//Show Results
		
		System.out.println("The response is:" + playlist);
	}
}
