package aiss.model.calendarific;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Datetime
{
	
    private String month;

    private String year;

    private String day;
    
    @JsonIgnore
    private String hour;
    
    @JsonIgnore
    private String minute;
    
    @JsonIgnore
    private String second;

    public String getMonth ()
    {
        return month;
    }

    public void setMonth (String month)
    {
        this.month = month;
    }

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    public String getDay ()
    {
        return day;
    }

    public void setDay (String day)
    {
        this.day = day;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [month = "+month+", year = "+year+", day = "+day+ "hour = " + hour + "minute = " + minute + "second = " + second +"]";
    }

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}
}
