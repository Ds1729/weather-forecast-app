package com.dhruv.weather.dto;

public class OpenForecastResponse {

    private ForecastItem[] list;

    public OpenForecastResponse() {
    }

    public ForecastItem[] getList() {
        return list;
    }

    public void setList(ForecastItem[] list) {
        this.list = list;
    }
}