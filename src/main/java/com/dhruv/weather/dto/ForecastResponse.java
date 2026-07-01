package com.dhruv.weather.dto;

import java.util.List;

public class ForecastResponse {

    private List<DailyForecast> forecast;

    public ForecastResponse() {
    }

    public List<DailyForecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<DailyForecast> forecast) {
        this.forecast = forecast;
    }
}