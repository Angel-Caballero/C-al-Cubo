package aiss.api;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import aiss.api.resources.PlaylistResource;
import aiss.api.resources.TrackResource;
import aiss.api.resources.WeatherResource;


public class WeatherApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public WeatherApplication() {

		singletons.add(WeatherResource.getInstance());
		singletons.add(PlaylistResource.getInstance());
		singletons.add(TrackResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
