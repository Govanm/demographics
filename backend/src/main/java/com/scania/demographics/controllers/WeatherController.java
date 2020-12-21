package com.scania.demographics.controllers;

import com.scania.demographics.domains.WeatherInfo;
import com.scania.demographics.domains.WeatherQueryResult;
import com.scania.demographics.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: demographics
 * Created on 2020-12-20.
 */
@RestController
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("demographics")
    public WeatherInfo weatherInfo(@RequestParam(value = "city") String cityName) {
        WeatherQueryResult queryResult = weatherService.getWeatherResult(cityName);
        return new WeatherInfo(
                queryResult.getLocation().getName(),
                queryResult.getLocation().getCountry(),
                queryResult.getCurrent().getTemperature(),
                queryResult.getCurrent().getWeatherCode()
        );
    }
}
