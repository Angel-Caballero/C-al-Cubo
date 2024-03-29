package aiss.model.deezer;

public class Artist{
    private String picture_xl;

    private String tracklist;

    private String picture_big;

    private String name;

    private String link;

    private String picture_small;

    private String id;

    private String type;

    private String picture;

    private String picture_medium;

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

    public String getPicture_big ()
    {
        return picture_big;
    }

    public void setPicture_big (String picture_big)
    {
        this.picture_big = picture_big;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
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

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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
        return "ClassPojo [picture_xl = "+picture_xl+", tracklist = "+tracklist+", picture_big = "+picture_big+", name = "+name+", link = "+link+", picture_small = "+picture_small+", id = "+id+", type = "+type+", picture = "+picture+", picture_medium = "+picture_medium+"]";
    }
}