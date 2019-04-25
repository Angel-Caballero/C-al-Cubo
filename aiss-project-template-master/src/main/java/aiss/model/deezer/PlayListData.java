package aiss.model.deezer;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PlayListData {
	
	@JsonProperty("nb_tracks")
	private String nbTracks;

	@JsonProperty("picture_xl")
	private String pictureXl;

	private String tracklist;

	private String link;

	@JsonProperty("picture_small")
	private String pictureSmall;

	@JsonProperty("creation_date")
	private String creationDate;

	private String title;

	private String type;

	private String picture;

	@JsonProperty("public")
	private String publico;

	@JsonProperty("picture_big")
	private String pictureBig;

	private String checksum;

	private String id;
	
	 private User user;

	@JsonProperty("picture_medium")
	private String pictureMedium;

	@JsonProperty("nb_tracks")
	public String getNbTracks ()
	{
		return nbTracks;
	}

	@JsonProperty("nb_tracks")
	public void setNbTracks (String nbTracks)
	{
		this.nbTracks = nbTracks;
	}

	@JsonProperty("picture_xl")
	public String getPicture_xl ()
	{
		return pictureXl;
	}

	@JsonProperty("picture_xl")
	public void setPictureXl (String pictureXl)
	{
	    this.pictureXl = pictureXl;
	}

	public String getTracklist ()
	{
		return tracklist;
	}

	public void setTracklist (String tracklist)
	{
		this.tracklist = tracklist;
	}

	    public String getLink ()
	    {
	        return link;
	    }

	    public void setLink (String link)
	    {
	        this.link = link;
	    }

	    @JsonProperty("picture_small")
	    public String getPictureSmall ()
	    {
	        return pictureSmall;
	    }

	    @JsonProperty("picture_small")
	    public void setPictureSmall (String pictureSmall)
	    {
	        this.pictureSmall = pictureSmall;
	    }

	    @JsonProperty("creation_date")
	    public String getCreationDate ()
	    {
	        return creationDate;
	    }

	    public void setCreationDate (String creationDate)
	    {
	        this.creationDate = creationDate;
	    }

	    public String getTitle ()
	    {
	        return title;
	    }

	    public void setTitle (String title)
	    {
	        this.title = title;
	    }

	    public String getType ()
	    {
	        return type;
	    }

	    public void setType (String type)
	    {
	        this.type = type;
	    }

	    public String getPicture ()
	    {
	        return picture;
	    }

	    public void setPicture (String picture)
	    {
	        this.picture = picture;
	    }

	    @JsonProperty("public")
	    public String getPublico ()
	    {
	        return publico;
	    }

	    @JsonProperty("public")
	    public void setPublic (String publico)
	    {
	        this.publico = publico;
	    }
	    @JsonProperty("picture_big")
	    public String getPictureBig ()
	    {
	        return pictureBig;
	    }

	    @JsonProperty("picture_big")
	    public void setPictureBig (String pictureBig)
	    {
	        this.pictureBig = pictureBig;
	    }

	    public String getChecksum ()
	    {
	        return checksum;
	    }

	    public void setChecksum (String checksum)
	    {
	        this.checksum = checksum;
	    }

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

		@JsonProperty("picture_medium")
	    public String getPictureMedium ()
	    {
	        return pictureMedium;
	    }

		@JsonProperty("picture_medium")
	    public void setPictureMedium (String pictureMedium)
	    {
	        this.pictureMedium = pictureMedium;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [nb_tracks = "+nbTracks+", picture_xl = "+pictureXl+", tracklist = "+tracklist+", link = "+link+", picture_small = "+pictureSmall+", creation_date = "+creationDate+", title = "+title+", type = "+type+", picture = "+picture+", public = "+publico+", picture_big = "+pictureBig+", checksum = "+checksum+", id = "+id+", pictureMedium = "+pictureMedium+"]";
	    }

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
}


