package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarListResponse {

	private String kind;

	private String nextSyncToken;
	
	private String nextPageToken;

	private String etag;

	private Items[] items;

	public String getKind ()
	{
		return kind;
	}

	public void setKind (String kind)
	{
		this.kind = kind;
	}

	public String getNextSyncToken ()
	{
		return nextSyncToken;
	}

	public void setNextSyncToken (String nextSyncToken)
	{
		this.nextSyncToken = nextSyncToken;
	}

	public String getEtag ()
	{
		return etag;
	}

	public void setEtag (String etag)
	{
		this.etag = etag;
	}

	public Items[] getItems ()
	{
		return items;
	}

	public void setItems (Items[] items)
	{
		this.items = items;
	}

	public String getNextPageToken() {
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [kind = "+kind+", nextSyncToken = "+nextSyncToken+", nextPageToken = "+nextPageToken+", etag = "+etag+", items = "+items+"]";
	}
}
