package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reminders {
	private String useDefault;

    public String getUseDefault ()
    {
        return useDefault;
    }

    public void setUseDefault (String useDefault)
    {
        this.useDefault = useDefault;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [useDefault = "+useDefault+"]";
    }
}
