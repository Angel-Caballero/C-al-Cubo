package aiss.model.googlecalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationSettings {
	private Notifications[] notifications;

	public Notifications[] getNotifications ()
	{
		return notifications;
	}

	public void setNotifications (Notifications[] notifications)
	{
		this.notifications = notifications;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [notifications = "+notifications+"]";
	}
}
