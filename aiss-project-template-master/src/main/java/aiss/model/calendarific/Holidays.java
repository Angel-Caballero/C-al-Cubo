package aiss.model.calendarific;

public class Holidays
{
    private Date date;

    private String name;

    private String description;

    private String[] type;

    public Date getDate ()
    {
        return date;
    }

    public void setDate (Date date)
    {
        this.date = date;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String[] getType ()
    {
        return type;
    }

    public void setType (String[] type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", name = "+name+", description = "+description+", type = "+type+"]";
    }
}
