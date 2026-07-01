package com.dhruv.weather.service;

import com.dhruv.weather.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.ArrayList;
import java.util.List;
import com.dhruv.weather.dto.DailyForecast;
import com.dhruv.weather.dto.ForecastItem;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestClient restClient;

    public WeatherService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://api.openweathermap.org")
                .build();
    }

    public WeatherResponse getCurrentWeather(String city) {

        OpenWeatherResponse response = restClient.get()
                .uri("/data/2.5/weather?q={city}&appid={key}&units=metric",
                        city, apiKey)
                .retrieve()
                .body(OpenWeatherResponse.class);

        WeatherResponse weatherResponse = new WeatherResponse();

        weatherResponse.setCity(response.getName());

        weatherResponse.setTemperature(
                response.getMain().getTemp()
        );

        weatherResponse.setHumidity(
                response.getMain().getHumidity()
        );

        weatherResponse.setDescription(
                response.getWeather()[0].getDescription()
        );

        return weatherResponse;
    }
    public ForecastResponse getForecast(String city) {

        OpenForecastResponse response = restClient.get()
                .uri("/data/2.5/forecast?q={city}&appid={key}&units=metric",
                        city, apiKey)
                .retrieve()
                .body(OpenForecastResponse.class);

        ForecastResponse forecastResponse = new ForecastResponse();

        List<DailyForecast> dailyForecasts = new ArrayList<>();

        for (ForecastItem item : response.getList()) {

            if (item.getDt_txt().contains("12:00:00")) {

                DailyForecast dailyForecast = new DailyForecast();

                dailyForecast.setDate(item.getDt_txt());

                dailyForecast.setTemperature(item.getMain().getTemp());

                dailyForecast.setHumidity(item.getMain().getHumidity());

                dailyForecast.setDescription(item.getWeather()[0].getDescription());

                dailyForecasts.add(dailyForecast);
            }
        }

        forecastResponse.setForecast(dailyForecasts);

        return forecastResponse;
    }


    }
