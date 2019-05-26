package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;
import aiss.model.Weather;
import aiss.model.repository.MapPlaylistRepository;
import aiss.model.repository.PlaylistRepository;

@Path("/weather")
public class WeatherResource {

	private static WeatherResource _instance=null;
	PlaylistRepository repository;
	
	private WeatherResource() {
		repository=MapPlaylistRepository.getInstance();

	}
	
	public static WeatherResource getInstance()
	{
		if(_instance==null)
				_instance=new WeatherResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Weather> getAll()
	{
		return repository.getAllWeather();
	}

@GET
@Path("/{id}")
@Produces("application/json")
public Weather get(@PathParam("id") String weatherId)
{
	Weather weather = repository.getWeather(weatherId);

	if(weather == null)
	{
		throw new NotFoundException("The weather with id " + weatherId + "was not found");
	}

	return weather;
}

@POST
@Consumes("application/json")
@Produces("application/json")
public Response addWeather(@Context UriInfo uriInfo, Weather weather) {
	if(weather.getName() == null || "".equals(weather.getName()))
		throw new BadRequestException("The name of the weather must not be null");
	
	repository.addWeather(weather);
	
	//Builds the response. Returns the weather that has just been added.
	UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
	URI uri = ub.build(weather.getId());
	ResponseBuilder resp = Response.created(uri);
	resp.entity(weather);
	
	return resp.build();
}

@PUT
@Consumes("application/json")
public Response updateWeather(Weather weather) {
	Weather oldWeather = repository.getWeather(weather.getId());
	if (oldWeather == null) {
		throw new NotFoundException("The weather with id="+ weather.getId() +" was not found");			
	}
	
	if(weather.getName() == null) {
		throw new NotFoundException("The weather with id= " +  weather.getName() + " was not found");
	}
	
	// Update name
	if (weather.getName()!=null)
		oldWeather.setName(weather.getName());
	
	return Response.noContent().build();
}

@DELETE
@Path("/{id}")
public Response removeWeather(@PathParam("id") String id) {
	Weather toberemoved=repository.getWeather(id);
	if (toberemoved == null)
		throw new NotFoundException("The weather with id="+ id +" was not found");
	else
		repository.deleteWeather(id);
	
	return Response.noContent().build();
}
}