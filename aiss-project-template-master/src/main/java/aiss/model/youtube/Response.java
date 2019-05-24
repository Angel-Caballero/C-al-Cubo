package aiss.model.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response
{
    private String kind;

    private String prevPageToken;
    
    private String nextPageToken;
    
    private PageInfo pageInfo;

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

    public PageInfo getPageInfo ()
    {
        return pageInfo;
    }

    public void setPageInfo (PageInfo pageInfo)
    {
        this.pageInfo = pageInfo;
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

	public String getPrevPageToken() {
		return prevPageToken;
	}

	public void setPrevPageToken(String prevPageToken) {
		this.prevPageToken = prevPageToken;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [kind = "+kind+", pageInfo = "+pageInfo+", etag = "+etag+", nextPageToken = "+nextPageToken+", prevPageToken = "+prevPageToken+", items = "+items+"]";
    }
}