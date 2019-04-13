package aiss.model.calendarific;

public class Response{
	
    private Holidays[] holidays;

    public Holidays[] getHolidays ()
    {
        return holidays;
    }

    public void setHolidays (Holidays[] holidays)
    {
        this.holidays = holidays;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [holidays = "+holidays+"]";
    }
}

