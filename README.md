# Weather Forecast Application

## Description

A Spring Boot application that fetches real-time weather data from the OpenWeather API.

## Technologies Used

- Java
- Spring Boot
- REST API
- OpenWeather API
- JSON Parsing

## Features

- Current weather
- Temperature
- Humidity
- Weather description
- 5-Day Forecast
- Error handling for invalid city

## API Endpoints

### Current Weather

GET /weather?city=Delhi

### 5-Day Forecast

GET /forecast?city=Delhi

## Sample Response

### Weather

```json
{
  "city": "Delhi",
  "temperature": 34.06,
  "humidity": 44,
  "description": "overcast clouds"
}
```

### Forecast

```json
{
  "forecast": [
    {
      "date": "2026-07-02 12:00:00",
      "temperature": 36.69,
      "humidity": 37,
      "description": "broken clouds"
    }
  ]
}
```