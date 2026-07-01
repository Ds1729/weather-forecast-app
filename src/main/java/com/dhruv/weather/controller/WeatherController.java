package com.dhruv.weather.controller;

import com.dhruv.weather.dto.ForecastResponse;
import com.dhruv.weather.dto.WeatherResponse;
import com.dhruv.weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) {

        return weatherService.getCurrentWeather(city);

    }
    @GetMapping("/forecast")
    public ForecastResponse getForecast(@RequestParam String city) {

        return weatherService.getForecast(city);

    }
}