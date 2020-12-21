package com.scania.demographics.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Project: demographics
 * Created on 2020-12-20.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {
    private int temperature;
    @JsonProperty("weather_code")
    private int weatherCode;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }
}
