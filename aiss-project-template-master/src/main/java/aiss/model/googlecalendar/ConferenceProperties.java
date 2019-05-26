package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConferenceProperties {
	private String[] allowedConferenceSolutionTypes;

    public String[] getAllowedConferenceSolutionTypes ()
    {
        return allowedConferenceSolutionTypes;
    }

    public void setAllowedConferenceSolutionTypes (String[] allowedConferenceSolutionTypes)
    {
        this.allowedConferenceSolutionTypes = allowedConferenceSolutionTypes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [allowedConferenceSolutionTypes = "+allowedConferenceSolutionTypes+"]";
    }
}
