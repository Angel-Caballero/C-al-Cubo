package aiss.model.deezer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data
{
    private String readable;

    private String preview;

    private Artist artist;

    private Album album;

    private String link;

    @JsonProperty("explicit_content_cover")
    private String explicitContentCover;

    private String title;

    @JsonProperty("title_version")
    private String titleVersion;

    @JsonProperty("explicit_lyrics")
    private String explicitLyrics;

    private String type;

    @JsonProperty("title_short")
    private String titleShort;

    private String duration;

    private String rank;

    private String id;

    @JsonProperty("explicit_content_lyrics")
    private String explicitContentLyrics;

    @JsonProperty("time_add")
    private String timeAdd;

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

    @JsonProperty("explicit_content_cover")
    public String getExplicitContentCover ()
    {
        return explicitContentCover;
    }

    @JsonProperty("explicit_content_cover")
    public void setExplicitContentCover (String explicitContentCover)
    {
        this.explicitContentCover = explicitContentCover;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    @JsonProperty("title_version")
    public String getTitleVersion ()
    {
        return titleVersion;
    }

    @JsonProperty("title_version")
    public void setTitleVersion (String titleVersion)
    {
        this.titleVersion = titleVersion;
    }

    @JsonProperty("explicit_lyrics")
    public String getExplicitLyrics ()
    {
        return explicitLyrics;
    }

    @JsonProperty("explicit_lyrics")
    public void setExplicitLyrics (String explicitLyrics)
    {
        this.explicitLyrics = explicitLyrics;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @JsonProperty("title_short")
    public String getTitleShort ()
    {
        return titleShort;
    }

    @JsonProperty("title_short")
    public void setTitleShort (String titleShort)
    {
        this.titleShort = titleShort;
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

    @JsonProperty("explicit_content_lyrics")
    public String getExplicitContentLyrics ()
    {
        return explicitContentLyrics;
    }

    @JsonProperty("explicit_content_lyrics")
    public void setExplicitContentLyrics (String explicitContentLyrics)
    {
        this.explicitContentLyrics = explicitContentLyrics;
    }

    @JsonProperty("time_add")
    public String getTimeAdd ()
    {
        return timeAdd;
    }

    @JsonProperty("time_add")
    public void setTimeAdd (String timeAdd)
    {
        this.timeAdd = timeAdd;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [readable = "+readable+", preview = "+preview+", artist = "+artist+", album = "+album+", link = "+link+", explicit_content_cover = "+explicitContentCover+", title = "+title+", title_version = "+titleVersion+", explicit_lyrics = "+explicitLyrics+", type = "+type+", titleShort = "+titleShort+", duration = "+duration+", rank = "+rank+", id = "+id+", explicit_content_lyrics = "+explicitContentLyrics+", timeAdd = "+timeAdd+"]";
    }
}