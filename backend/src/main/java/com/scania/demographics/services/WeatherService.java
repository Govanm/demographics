package com.scania.demographics.services;

import com.scania.demographics.domains.WeatherQueryResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: demographics
 * Created on 2020-12-20.
 */
@Service
public class WeatherService {
    private static  String apiKey =  "43c3391a83cd632232f68dc21386a995";
    private static String url = "http://api.weatherstack.com/current?access_key={access_key}&query={query}";

    public WeatherQueryResult getWeatherResult(String cityName) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("access_key", apiKey);
        parameters.put("query", cityName);
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject(url, WeatherQueryResult.class, parameters);
    }
}
