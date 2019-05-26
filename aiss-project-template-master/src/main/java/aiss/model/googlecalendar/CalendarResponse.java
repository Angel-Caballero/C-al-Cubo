package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarResponse {
	   private String summary;

	    private ConferenceProperties conferenceProperties;

	    private String kind;

	    private String timeZone;

	    private String etag;

	    private String id;

	    public String getSummary ()
	    {
	        return summary;
	    }

	    public void setSummary (String summary)
	    {
	        this.summary = summary;
	    }

	    public ConferenceProperties getConferenceProperties ()
	    {
	        return conferenceProperties;
	    }

	    public void setConferenceProperties (ConferenceProperties conferenceProperties)
	    {
	        this.conferenceProperties = conferenceProperties;
	    }

	    public String getKind ()
	    {
	        return kind;
	    }

	    public void setKind (String kind)
	    {
	        this.kind = kind;
	    }

	    public String getTimeZone ()
	    {
	        return timeZone;
	    }

	    public void setTimeZone (String timeZone)
	    {
	        this.timeZone = timeZone;
	    }

	    public String getEtag ()
	    {
	        return etag;
	    }

	    public void setEtag (String etag)
	    {
	        this.etag = etag;
	    }

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [summary = "+summary+", conferenceProperties = "+conferenceProperties+", kind = "+kind+", timeZone = "+timeZone+", etag = "+etag+", id = "+id+"]";
	    }
}
