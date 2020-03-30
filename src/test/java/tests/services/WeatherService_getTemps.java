package tests.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import services.WeatherService;

import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeatherService_getTemps {
    private WeatherService weatherService;

    @BeforeAll
    void beforeAll() {
        weatherService = new WeatherService();
    }

    @Test
    public void testWeatherService_getTemps_RoundRock(){
        weatherService.getWeather("Round Rock","TX")
                .validateHttpStatusCode(200)
                .validateResponseFieldValues(
                        Map.of("Code","Success")
                );
    }

    @Test
    public void testWeatherService_getTemps_Tampa(){
        weatherService.getWeather("Tampa","TX")
                .validateHttpStatusCode(404);
    }

    @Test
    public void testWeatherService_getTemps_empty(){
        weatherService.getWeather("","")
                .validateHttpStatusCode(400);
    }
}