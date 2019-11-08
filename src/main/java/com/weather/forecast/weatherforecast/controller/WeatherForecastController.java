package com.weather.forecast.weatherforecast.controller;

import com.weather.forecast.weatherforecast.data.WeatherData;
import com.weather.forecast.weatherforecast.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forecast")
public class WeatherForecastController {

    @Autowired
    private WeatherForecastService weatherForeCastService;


    @GetMapping(value = "/weather")
    public WeatherData getWeatherForecast(@RequestParam String city){

       return weatherForeCastService.getWeather(city);
    }

}
