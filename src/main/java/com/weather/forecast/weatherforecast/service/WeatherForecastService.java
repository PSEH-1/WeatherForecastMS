package com.weather.forecast.weatherforecast.service;

import com.weather.forecast.weatherforecast.data.WeatherData;

public interface WeatherForecastService {
     WeatherData getWeather(String city);
     String getWeatherForLowTemp(String city);
     String getWeatherForHighTemp(String city);
}
