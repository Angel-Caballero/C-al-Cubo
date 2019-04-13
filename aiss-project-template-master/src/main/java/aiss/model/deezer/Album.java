package aiss.model.deezer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Album
{
    private String cover;

    private String tracklist;

    @JsonProperty("cover_xl")
    private String coverXl;

    @JsonProperty("cover_medium")
    private String coverMedium;

    @JsonProperty("cover_small")
    private String coverSmall;

    private String id;

    private String title;

    private String type;

    @JsonProperty("cover_big")
    private String coverBig;

    public String getCover ()
    {
        return cover;
    }

    public void setCover (String cover)
    {
        this.cover = cover;
    }

    public String getTracklist ()
    {
        return tracklist;
    }

    public void setTracklist (String tracklist)
    {
        this.tracklist = tracklist;
    }

    @JsonProperty("cover_xl")
    public String getCoverXl ()
    {
        return coverXl;
    }

    @JsonProperty("cover_xl")
    public void setCoverXl (String coverXl)
    {
        this.coverXl = coverXl;
    }

    @JsonProperty("cover_medium")
    public String getCoverMedium ()
    {
        return coverMedium;
    }

    @JsonProperty("cover_medium")
    public void setCoverMedium (String coverMedium)
    {
        this.coverMedium = coverMedium;
    }

    @JsonProperty("cover_small")
    public String getCoverSmall ()
    {
        return coverSmall;
    }

    @JsonProperty("cover_small")
    public void setCoverSmall (String coverSmall)
    {
        this.coverSmall = coverSmall;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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

    @JsonProperty("cover_big")
    public String getCoverBig ()
    {
        return coverBig;
    }

    @JsonProperty("cover_big")
    public void setCoverBig (String coverBig)
    {
        this.coverBig = coverBig;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cover = "+cover+", tracklist = "+tracklist+", cover_xl = "+coverXl+", cover_medium = "+coverMedium+", cover_small = "+coverSmall+", id = "+id+", title = "+title+", type = "+type+", coverBig = "+coverBig+"]";
    }
}
