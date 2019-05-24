package aiss.model.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status
{
    private String privacyStatus;

    public String getPrivacyStatus ()
    {
        return privacyStatus;
    }

    public void setPrivacyStatus (String privacyStatus)
    {
        this.privacyStatus = privacyStatus;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [privacyStatus = "+privacyStatus+"]";
    }
}