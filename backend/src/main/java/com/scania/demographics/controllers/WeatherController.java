package com.scania.demographics.controllers;

import com.scania.demographics.domains.WeatherInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: demographics
 * Created on 2020-12-20.
 */
@RestController
public class WeatherController {

    @GetMapping("demographics")
    public WeatherInfo weatherInfo(@RequestParam(value = "city" ) String cityName){
        return new WeatherInfo("Stockholm", "Sweden", 10, 21);
    }
}
