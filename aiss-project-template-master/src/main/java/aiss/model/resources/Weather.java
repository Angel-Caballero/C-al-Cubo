package aiss.model.resources;

public class Weather {
  private static String URI = "api.openweathermap.org/data/2.5/weather?";
  private static String API_KEY = "eaddc12fe18c112838e912e6534cb747";
	private static final Logger log = Logger.getLogger(Weather.class.getName());

public getWeather(String qCountry, String qCity)throws UnsupportedEncodingException {
  String country = URLEncoder.encode(qCountry, "UTF-8");
  String city = URLEncoder.encode(qCity, "UTF-8");
  String uri = URI + "q="+ city + "," + country+ "&appid=" + API_KEY;

  ClientResource cr = null;
  Forecast weather = null;
  try {
    cr = new ClientResource(uri);
    weather = cr.get(Forecast.class);
  } catch (ResourceException re) {
    System.err.println("Error when retrieving the weather: " + cr.getResponse().getStatus());
  }
    return weather;
}
}
