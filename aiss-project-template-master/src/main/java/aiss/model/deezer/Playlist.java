package aiss.model.deezer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Playlist {
	public class PlayList
	{
	    private String nb_tracks;

	    private String picture_xl;

	    private String tracklist;

	    private Creator creator;

	    private String collaborative;

	    private String link;

	    private String picture_small;

	    private String description;

	    private String creation_date;

	    private String title;

	    private String type;

	    private String picture;

	    private Tracks tracks;

	    private String fans;

	    private String duration;

	    private String is_loved_track;

	    @JsonProperty("public")
	    private String publico;

	    private String picture_big;

	    private String checksum;

	    private String share;

	    private String id;

	    private String picture_medium;

	    public String getNb_tracks ()
	    {
	        return nb_tracks;
	    }

	    public void setNb_tracks (String nb_tracks)
	    {
	        this.nb_tracks = nb_tracks;
	    }

	    public String getPicture_xl ()
	    {
	        return picture_xl;
	    }

	    public void setPicture_xl (String picture_xl)
	    {
	        this.picture_xl = picture_xl;
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

	    public String getPicture_small ()
	    {
	        return picture_small;
	    }

	    public void setPicture_small (String picture_small)
	    {
	        this.picture_small = picture_small;
	    }

	    public String getDescription ()
	    {
	        return description;
	    }

	    public void setDescription (String description)
	    {
	        this.description = description;
	    }

	    public String getCreation_date ()
	    {
	        return creation_date;
	    }

	    public void setCreation_date (String creation_date)
	    {
	        this.creation_date = creation_date;
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

	    public String getIs_loved_track ()
	    {
	        return is_loved_track;
	    }

	    public void setIs_loved_track (String is_loved_track)
	    {
	        this.is_loved_track = is_loved_track;
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

	    public String getPicture_big ()
	    {
	        return picture_big;
	    }

	    public void setPicture_big (String picture_big)
	    {
	        this.picture_big = picture_big;
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
	        return "ClassPojo [nb_tracks = "+nb_tracks+", picture_xl = "+picture_xl+", tracklist = "+tracklist+", creator = "+ creator +", collaborative = "+collaborative+", link = "+link+", picture_small = "+picture_small+", description = "+description+", creation_date = "+creation_date+", title = "+title+", type = "+type+", picture = "+picture+", tracks = "+tracks+", fans = "+fans+", duration = "+duration+", is_loved_track = "+is_loved_track+", public = "+publico+", picture_big = "+picture_big+", checksum = "+checksum+", share = "+share+", id = "+id+", picture_medium = "+picture_medium+"]";
	    }
	}

}
