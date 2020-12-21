package com.scania.demographics.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Project: demographics
 * Created on 2020-12-20.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherQueryResult {

    private Location location;
    private CurrentWeather current;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }
}
