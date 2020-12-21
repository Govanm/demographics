package com.scania.demographics.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentWeather)) return false;
        CurrentWeather that = (CurrentWeather) o;
        return temperature == that.temperature && weatherCode == that.weatherCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, weatherCode);
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "temperature=" + temperature +
                ", weatherCode=" + weatherCode +
                '}';
    }
}
