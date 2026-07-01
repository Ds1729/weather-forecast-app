package com.dhruv.weather.controller;

import com.dhruv.weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final WeatherService weatherService;

    public HelloController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Dhruv! Welcome to Weather Forecast Application";
    }
}