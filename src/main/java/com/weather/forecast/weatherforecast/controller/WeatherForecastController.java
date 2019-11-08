package com.weather.forecast.weatherforecast.controller;

import com.weather.forecast.weatherforecast.data.WeatherData;
import com.weather.forecast.weatherforecast.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forecast")
public class WeatherForecastController {

    @Autowired
    private WeatherForecastService weatherForeCastService;


    @GetMapping(value = "/list")
    public WeatherData getWeatherForecast(@PathVariable String city){

       return weatherForeCastService.getWeather(city);
    }

}
