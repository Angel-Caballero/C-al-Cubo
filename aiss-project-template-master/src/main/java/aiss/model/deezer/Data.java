package aiss.model.deezer;

public class Data
{
    private String readable;

    private String preview;

    private Artist artist;

    private Album album;

    private String link;

    private String explicit_content_cover;

    private String title;

    private String title_version;

    private String explicit_lyrics;

    private String type;

    private String title_short;

    private String duration;

    private String rank;

    private String id;

    private String explicit_content_lyrics;

    private String time_add;

    public String getReadable ()
    {
        return readable;
    }

    public void setReadable (String readable)
    {
        this.readable = readable;
    }

    public String getPreview ()
    {
        return preview;
    }

    public void setPreview (String preview)
    {
        this.preview = preview;
    }

    public Artist getArtist ()
    {
        return artist;
    }

    public void setArtist (Artist artist)
    {
        this.artist = artist;
    }

    public Album getAlbum ()
    {
        return album;
    }

    public void setAlbum (Album album)
    {
        this.album = album;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getExplicit_content_cover ()
    {
        return explicit_content_cover;
    }

    public void setExplicit_content_cover (String explicit_content_cover)
    {
        this.explicit_content_cover = explicit_content_cover;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getTitle_version ()
    {
        return title_version;
    }

    public void setTitle_version (String title_version)
    {
        this.title_version = title_version;
    }

    public String getExplicit_lyrics ()
    {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics (String explicit_lyrics)
    {
        this.explicit_lyrics = explicit_lyrics;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getTitle_short ()
    {
        return title_short;
    }

    public void setTitle_short (String title_short)
    {
        this.title_short = title_short;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getExplicit_content_lyrics ()
    {
        return explicit_content_lyrics;
    }

    public void setExplicit_content_lyrics (String explicit_content_lyrics)
    {
        this.explicit_content_lyrics = explicit_content_lyrics;
    }

    public String getTime_add ()
    {
        return time_add;
    }

    public void setTime_add (String time_add)
    {
        this.time_add = time_add;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [readable = "+readable+", preview = "+preview+", artist = "+artist+", album = "+album+", link = "+link+", explicit_content_cover = "+explicit_content_cover+", title = "+title+", title_version = "+title_version+", explicit_lyrics = "+explicit_lyrics+", type = "+type+", title_short = "+title_short+", duration = "+duration+", rank = "+rank+", id = "+id+", explicit_content_lyrics = "+explicit_content_lyrics+", time_add = "+time_add+"]";
    }
}