package aiss.model.calendarific;

public class States
{
    private String exception;

    private String iso;

    private String name;

    private String id;

    private String abbrev;

    public String getException ()
    {
        return exception;
    }

    public void setException (String exception)
    {
        this.exception = exception;
    }

    public String getIso ()
    {
        return iso;
    }

    public void setIso (String iso)
    {
        this.iso = iso;
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

    public String getAbbrev ()
    {
        return abbrev;
    }

    public void setAbbrev (String abbrev)
    {
        this.abbrev = abbrev;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [exception = "+exception+", iso = "+iso+", name = "+name+", id = "+id+", abbrev = "+abbrev+"]";
    }
}
