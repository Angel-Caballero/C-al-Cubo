package aiss.model.calendarific;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Holidays
{
	
    private Date date;

    private String name;

    private String description;

    private String locations;

    private String[] type;

    @JsonIgnore
    private String states;

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

    public String getLocations ()
    {
        return locations;
    }

    public void setLocations (String locations)
    {
        this.locations = locations;
    }

    public String[] getType ()
    {
        return type;
    }

    public void setType (String[] type)
    {
        this.type = type;
    }

    public String getStates ()
    {
        return states;
    }

    public void setStates (String states)
    {
        this.states = states;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", name = "+name+", description = "+description+", locations = "+locations+", type = "+type+", states = "+states+"]";
    }
}
