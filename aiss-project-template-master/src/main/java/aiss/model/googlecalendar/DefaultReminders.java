package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultReminders {
	private String method;

	private String minutes;

	public String getMethod ()
	{
		return method;
	}

	public void setMethod (String method)
	{
		this.method = method;
	}

	public String getMinutes ()
	{
		return minutes;
	}

	public void setMinutes (String minutes)
	{
		this.minutes = minutes;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [method = "+method+", minutes = "+minutes+"]";
	}
}
