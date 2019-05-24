package aiss.model.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Snippet
{
    private String publishedAt;

    private Localized localized;

    private String description;

    private String title;

    private Thumbnails thumbnails;

    private String channelId;

    private String channelTitle;

    public String getPublishedAt ()
    {
        return publishedAt;
    }

    public void setPublishedAt (String publishedAt)
    {
        this.publishedAt = publishedAt;
    }

    public Localized getLocalized ()
    {
        return localized;
    }

    public void setLocalized (Localized localized)
    {
        this.localized = localized;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public Thumbnails getThumbnails ()
    {
        return thumbnails;
    }

    public void setThumbnails (Thumbnails thumbnails)
    {
        this.thumbnails = thumbnails;
    }

    public String getChannelId ()
    {
        return channelId;
    }

    public void setChannelId (String channelId)
    {
        this.channelId = channelId;
    }

    public String getChannelTitle ()
    {
        return channelTitle;
    }

    public void setChannelTitle (String channelTitle)
    {
        this.channelTitle = channelTitle;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [publishedAt = "+publishedAt+", localized = "+localized+", description = "+description+", title = "+title+", thumbnails = "+thumbnails+", channelId = "+channelId+", channelTitle = "+channelTitle+"]";
    }
}