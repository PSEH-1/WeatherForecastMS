package com.weather.forecast.weatherforecast.service.impl;

import com.weather.forecast.weatherforecast.data.WeatherData;
import com.weather.forecast.weatherforecast.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

    @Value("${weather.forecast.url}")
    private String weatherForecastURL;
    @Value("${weather.forecast.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherForecastServiceImpl() {
        restTemplate = new RestTemplate();
    }

    @Cacheable("weather")
    public WeatherData getWeather(String city){
        WeatherData weather = null;
        if(validParameters(city)) {
            URI url = new UriTemplate(this.weatherForecastURL).expand(city, this.apiKey);

            weather = invoke(url, WeatherData.class);
        }
        return weather;
    }

    private boolean validParameters(String city) {
        return city !=null && !"".equals(city) && apiKey !=null && !"".equals(apiKey) && weatherForecastURL!=null && !"".equals(weatherForecastURL);
    }

    private <T> T invoke(URI url, Class<T> responseType){
        T weather = null;
        try {
            RequestEntity<?> request = RequestEntity.get(url)
                    .accept(MediaType.APPLICATION_JSON).build();
            ResponseEntity<T> exchange = restTemplate
                    .exchange(request, responseType);
            weather = exchange.getBody();
        } catch(Exception e){
            e.printStackTrace();
        }

        return weather;
    }
}
