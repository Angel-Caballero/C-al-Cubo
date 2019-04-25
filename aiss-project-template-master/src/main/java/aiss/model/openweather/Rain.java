package aiss.model.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain
{
	@JsonProperty("3h")
    private String last3Hours;

	@JsonProperty("3h")
    public String getlast3Hours ()
    {
        return last3Hours;
    }

    public void set3h (String last3Hours)
    {
        this.last3Hours = last3Hours;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [3h = "+ last3Hours+"]";
    }
}