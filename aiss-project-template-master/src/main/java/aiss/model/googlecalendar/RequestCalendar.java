package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestCalendar {
	
	@JsonProperty("summary")
	private String summary;

	@JsonProperty("description")
    private String description;

    @JsonProperty("summary")
    public String getSummary ()
    {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    @JsonProperty("description")
    public String getDescription ()
    {
        return description;
    }

    @JsonProperty("description")
    public void setDescription (String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", description = "+description+"]";
    }
}
