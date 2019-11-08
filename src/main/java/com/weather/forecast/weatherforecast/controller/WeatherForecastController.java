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


    @GetMapping(value = "/forecast/general")
    public WeatherData getWeatherForecast(@PathVariable String city){

       return weatherForeCastService.getWeather(city);
    }


    @RequestMapping(value = "/forecast/{city}/lowTemperature", method=RequestMethod.GET)
    public String getWeatherLowTemp(@PathVariable final String city)
    {

        return weatherForeCastService.getWeatherForLowTemp(city);
    }

    @RequestMapping(value = "/forecast/{city}/highTemperature", method=RequestMethod.GET)
    public String getWeatherHighTemp(@PathVariable final String city)
    {
   return weatherForeCastService.getWeatherForHighTemp(city);
    }

}
