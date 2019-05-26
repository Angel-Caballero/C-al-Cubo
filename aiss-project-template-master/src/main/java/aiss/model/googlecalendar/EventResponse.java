package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResponse {
	 private String summary;

	    private Reminders reminders;

	    private Creator creator;

	    private String kind;

	    private String htmlLink;

	    private String created;

	    private String iCalUID;

	    private Start start;

	    private String description;

	    private String sequence;

	    private Organizer organizer;

	    private String etag;

	    private End end;

	    private String id;

	    private String updated;

	    private String status;

	    public String getSummary ()
	    {
	        return summary;
	    }

	    public void setSummary (String summary)
	    {
	        this.summary = summary;
	    }

	    public Reminders getReminders ()
	    {
	        return reminders;
	    }

	    public void setReminders (Reminders reminders)
	    {
	        this.reminders = reminders;
	    }

	    public Creator getCreator ()
	    {
	        return creator;
	    }

	    public void setCreator (Creator creator)
	    {
	        this.creator = creator;
	    }

	    public String getKind ()
	    {
	        return kind;
	    }

	    public void setKind (String kind)
	    {
	        this.kind = kind;
	    }

	    public String getHtmlLink ()
	    {
	        return htmlLink;
	    }

	    public void setHtmlLink (String htmlLink)
	    {
	        this.htmlLink = htmlLink;
	    }

	    public String getCreated ()
	    {
	        return created;
	    }

	    public void setCreated (String created)
	    {
	        this.created = created;
	    }

	    public String getICalUID ()
	    {
	        return iCalUID;
	    }

	    public void setICalUID (String iCalUID)
	    {
	        this.iCalUID = iCalUID;
	    }

	    public Start getStart ()
	    {
	        return start;
	    }

	    public void setStart (Start start)
	    {
	        this.start = start;
	    }

	    public String getDescription ()
	    {
	        return description;
	    }

	    public void setDescription (String description)
	    {
	        this.description = description;
	    }

	    public String getSequence ()
	    {
	        return sequence;
	    }

	    public void setSequence (String sequence)
	    {
	        this.sequence = sequence;
	    }

	    public Organizer getOrganizer ()
	    {
	        return organizer;
	    }

	    public void setOrganizer (Organizer organizer)
	    {
	        this.organizer = organizer;
	    }

	    public String getEtag ()
	    {
	        return etag;
	    }

	    public void setEtag (String etag)
	    {
	        this.etag = etag;
	    }

	    public End getEnd ()
	    {
	        return end;
	    }

	    public void setEnd (End end)
	    {
	        this.end = end;
	    }

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getUpdated ()
	    {
	        return updated;
	    }

	    public void setUpdated (String updated)
	    {
	        this.updated = updated;
	    }

	    public String getStatus ()
	    {
	        return status;
	    }

	    public void setStatus (String status)
	    {
	        this.status = status;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [summary = "+summary+", reminders = "+reminders+", creator = "+creator+", kind = "+kind+", htmlLink = "+htmlLink+", created = "+created+", iCalUID = "+iCalUID+", start = "+start+", description = "+description+", sequence = "+sequence+", organizer = "+organizer+", etag = "+etag+", end = "+end+", id = "+id+", updated = "+updated+", status = "+status+"]";
	    }
}
