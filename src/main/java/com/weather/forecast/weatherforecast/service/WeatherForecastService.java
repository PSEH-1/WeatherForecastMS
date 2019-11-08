package com.weather.forecast.weatherforecast.service;

import com.weather.forecast.weatherforecast.data.WeatherData;

public interface WeatherForecastService {
    public WeatherData getWeather(String city);
}
