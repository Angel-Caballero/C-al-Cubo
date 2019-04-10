package aiss.model.deezer;

public class Creator
{
    private String tracklist;

    private String name;

    private String id;

    private String type;

    public String getTracklist ()
    {
        return tracklist;
    }

    public void setTracklist (String tracklist)
    {
        this.tracklist = tracklist;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
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

    @Override
    public String toString()
    {
        return "ClassPojo [tracklist = "+tracklist+", name = "+name+", id = "+id+", type = "+type+"]";
    }
}
