package aiss.model.deezer;

public class Album{
	
    private String cover;

    private String tracklist;

    private String cover_xl;

    private String cover_medium;

    private String cover_small;

    private String id;

    private String title;

    private String type;

    private String cover_big;

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

    public String getCover_xl ()
    {
        return cover_xl;
    }

    public void setCover_xl (String cover_xl)
    {
        this.cover_xl = cover_xl;
    }

    public String getCover_medium ()
    {
        return cover_medium;
    }

    public void setCover_medium (String cover_medium)
    {
        this.cover_medium = cover_medium;
    }

    public String getCover_small ()
    {
        return cover_small;
    }

    public void setCover_small (String cover_small)
    {
        this.cover_small = cover_small;
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

    public String getCover_big ()
    {
        return cover_big;
    }

    public void setCover_big (String cover_big)
    {
        this.cover_big = cover_big;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cover = "+cover+", tracklist = "+tracklist+", cover_xl = "+cover_xl+", cover_medium = "+cover_medium+", cover_small = "+cover_small+", id = "+id+", title = "+title+", type = "+type+", cover_big = "+cover_big+"]";
    }
}
