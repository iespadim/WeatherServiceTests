package services;

import exceptions.HttpRequestException;
import helpers.ResponseHelper;

import java.util.Map;


public class WeatherService extends NonAuthenticatedService {

    public WeatherService() {
        super(WeatherService.class);
    }

    public ResponseHelper getWeather(final String cityName, final String cityState){
        try {
            return get("Get Weather by City API",
                    "This API provides current weather information for US Cities, updated hourly. ",
                    "https://api.interzoid.com",
                    "/getweather",
                    Map.of(),
                    Map.of("license","718abf54b490be4b2859157beaf2fa54", "city",cityName,"state",cityState),
                    Map.of());
        } catch (final HttpRequestException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
