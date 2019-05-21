package aiss.model.deezer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User
{
    private String country;

    @JsonProperty("picture_xl")
    private String pictureXl;

    private String tracklist;

    @JsonProperty("picture_big")
    private String pictureBig;

    private String name;

    private String link;

    @JsonProperty("picture_small")
    private String pictureSmall;

    private String id;

    private String type;

    private String picture;

    @JsonProperty("picture_medium")
    private String pictureMedium;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getPictureXl ()
    {
        return pictureXl;
    }

    public void setPictureXl (String picture_xl)
    {
        this.pictureXl = picture_xl;
    }

    public String getTracklist ()
    {
        return tracklist;
    }

    public void setTracklist (String tracklist)
    {
        this.tracklist = tracklist;
    }

    public String getPictureBig ()
    {
        return pictureBig;
    }

    public void setPictureBig (String picture_big)
    {
        this.pictureBig = picture_big;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getPictureSmall ()
    {
        return pictureSmall;
    }

    public void setPictureSmall (String picture_small)
    {
        this.pictureSmall = picture_small;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getPicture ()
    {
        return picture;
    }

    public void setPicture (String picture)
    {
        this.picture = picture;
    }

    public String getPicture_medium ()
    {
        return pictureMedium;
    }

    public void setPicture_medium (String picture_medium)
    {
        this.pictureMedium = picture_medium;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [country = "+country+", picture_xl = "+pictureXl+", tracklist = "+tracklist+", picture_big = "+pictureBig+", name = "+name+", link = "+link+", picture_small = "+pictureSmall+", id = "+id+", type = "+type+", picture = "+picture+", picture_medium = "+pictureMedium+"]";
    }
}