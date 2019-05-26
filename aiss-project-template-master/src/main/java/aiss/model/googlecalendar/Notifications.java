package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notifications {
	private String method;

	private String type;

	public String getMethod ()
	{
		return method;
	}

	public void setMethod (String method)
	{
		this.method = method;
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
		return "ClassPojo [method = "+method+", type = "+type+"]";
	}
}
