package aiss.model;

public class Track {

	private String id;
	private String title;
	private String artist;
	private String album;
	private String year;
	
	
	public Track() {
	}

	public Track(String id, String title, String artist, String album, String year) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}

	public Track(String title, String artist, String album, String year) {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
}
