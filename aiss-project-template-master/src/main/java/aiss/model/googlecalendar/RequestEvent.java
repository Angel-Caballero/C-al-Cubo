package aiss.model.googlecalendar;

public class RequestEvent {

	private String summary;

    private Start start;

    private String description;

    private End end;

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public Start getStart ()
    {
        return start;
    }

    public void setStart (Start start)
    {
        this.start = start;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public End getEnd ()
    {
        return end;
    }

    public void setEnd (End end)
    {
        this.end = end;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", start = "+start+", description = "+description+", end = "+end+"]";
    }
}
