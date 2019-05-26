package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
	private String summary;

	private ConferenceProperties conferenceProperties;

	private String backgroundColor;

	private String kind;

	private String colorId;

	private String timeZone;

	private String foregroundColor;

	private NotificationSettings notificationSettings;

	private DefaultReminders[] defaultReminders;

	private String accessRole;

	private String etag;

	private String id;

	private String selected;

	private String primary;

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

	public String getBackgroundColor ()
	{
		return backgroundColor;
	}

	public void setBackgroundColor (String backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	public String getKind ()
	{
		return kind;
	}

	public void setKind (String kind)
	{
		this.kind = kind;
	}

	public String getColorId ()
	{
		return colorId;
	}

	public void setColorId (String colorId)
	{
		this.colorId = colorId;
	}

	public String getTimeZone ()
	{
		return timeZone;
	}

	public void setTimeZone (String timeZone)
	{
		this.timeZone = timeZone;
	}

	public String getForegroundColor ()
	{
		return foregroundColor;
	}

	public void setForegroundColor (String foregroundColor)
	{
		this.foregroundColor = foregroundColor;
	}

	public NotificationSettings getNotificationSettings ()
	{
		return notificationSettings;
	}

	public void setNotificationSettings (NotificationSettings notificationSettings)
	{
		this.notificationSettings = notificationSettings;
	}

	public DefaultReminders[] getDefaultReminders ()
	{
		return defaultReminders;
	}

	public void setDefaultReminders (DefaultReminders[] defaultReminders)
	{
		this.defaultReminders = defaultReminders;
	}

	public String getAccessRole ()
	{
		return accessRole;
	}

	public void setAccessRole (String accessRole)
	{
		this.accessRole = accessRole;
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

	public String getSelected ()
	{
		return selected;
	}

	public void setSelected (String selected)
	{
		this.selected = selected;
	}

	public String getPrimary ()
	{
		return primary;
	}

	public void setPrimary (String primary)
	{
		this.primary = primary;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [summary = "+summary+", conferenceProperties = "+conferenceProperties+", backgroundColor = "+backgroundColor+", kind = "+kind+", colorId = "+colorId+", timeZone = "+timeZone+", foregroundColor = "+foregroundColor+", notificationSettings = "+notificationSettings+", defaultReminders = "+defaultReminders+", accessRole = "+accessRole+", etag = "+etag+", id = "+id+", selected = "+selected+", primary = "+primary+"]";
	}
}
