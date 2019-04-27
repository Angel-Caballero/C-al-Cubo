package aiss.model.calendarific;

public class Date
{
    private Datetime datetime;

    private String iso;
    
    private Timezone timezone;

    public Datetime getDatetime ()
    {
        return datetime;
    }

    public void setDatetime (Datetime datetime)
    {
        this.datetime = datetime;
    }

    public String getIso ()
    {
        return iso;
    }

    public void setIso (String iso)
    {
        this.iso = iso;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [datetime = "+datetime+", iso = "+iso+ ", timezone = "+timezone+ "]";
    }

	public Timezone getTimezone() {
		return timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
}
