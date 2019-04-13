package aiss.model.deezer;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PlayList {
	
	@JsonProperty("nb_tracks")
	private String nbTracks;

	@JsonProperty("picture_xl")
	private String pictureXl;

	private String tracklist;

	private Creator creator;

	private String collaborative;

	private String link;

	@JsonProperty("picture_small")
	private String pictureSmall;

	private String description;

	@JsonProperty("creation_date")
	private String creationDate;

	private String title;

	private String type;

	private String picture;

	private Tracks tracks;

	private String fans;

	private String duration;

	@JsonProperty("is_loved_track")
	private String isLovedTrack;

	@JsonProperty("public")
	private String publico;

	@JsonProperty("picture_big")
	private String pictureBig;

	private String checksum;

	private String share;

	private String id;

	private String picture_medium;

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

	public Creator getCreator ()
	{
	    return creator;
	}

	public void setCreator (Creator creator)
	{
		this.creator = creator;
	}

	    public String getCollaborative ()
	    {
	        return collaborative;
	    }

	    public void setCollaborative (String collaborative)
	    {
	        this.collaborative = collaborative;
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

	    public String getDescription ()
	    {
	        return description;
	    }

	    public void setDescription (String description)
	    {
	        this.description = description;
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

	    public Tracks getTracks ()
	    {
	        return tracks;
	    }

	    public void setTracks (Tracks tracks)
	    {
	        this.tracks = tracks;
	    }

	    public String getFans ()
	    {
	        return fans;
	    }

	    public void setFans (String fans)
	    {
	        this.fans = fans;
	    }

	    public String getDuration ()
	    {
	        return duration;
	    }

	    public void setDuration (String duration)
	    {
	        this.duration = duration;
	    }

	    @JsonProperty("is_loved_track")
	    public String getIsLovedTrack ()
	    {
	        return isLovedTrack;
	    }

	    @JsonProperty("is_loved_track")
	    public void setIsLovedTrack (String isLovedTrack)
	    {
	        this.isLovedTrack = isLovedTrack;
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

	    public String getShare ()
	    {
	        return share;
	    }

	    public void setShare (String share)
	    {
	        this.share = share;
	    }

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getPicture_medium ()
	    {
	        return picture_medium;
	    }

	    public void setPicture_medium (String picture_medium)
	    {
	        this.picture_medium = picture_medium;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [nb_tracks = "+nbTracks+", picture_xl = "+pictureXl+", tracklist = "+tracklist+", creator = "+ creator +", collaborative = "+collaborative+", link = "+link+", picture_small = "+pictureSmall+", description = "+description+", creation_date = "+creationDate+", title = "+title+", type = "+type+", picture = "+picture+", tracks = "+tracks+", fans = "+fans+", duration = "+duration+", is_loved_track = "+isLovedTrack+", public = "+publico+", picture_big = "+pictureBig+", checksum = "+checksum+", share = "+share+", id = "+id+", picture_medium = "+picture_medium+"]";
	    }
}


