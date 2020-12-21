package com.scania.demographics.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherQueryResult)) return false;
        WeatherQueryResult that = (WeatherQueryResult) o;
        return Objects.equals(location, that.location) && Objects.equals(current, that.current);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, current);
    }

    @Override
    public String toString() {
        return "WeatherQueryResult{" +
                "location=" + location +
                ", current=" + current +
                '}';
    }
}
