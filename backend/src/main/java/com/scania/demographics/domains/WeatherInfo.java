package com.scania.demographics.domains;

import java.util.Objects;

/**
   Project: demographics 
 * Created on 2020-12-20.
 */
public class WeatherInfo {
    private final int temperature;
    private final String city;
    private final String country;
    private final int weatherCode;

    public WeatherInfo(String city, String country, int temperature, int weatherCode) {
        this.temperature = temperature;
        this.city = city;
        this.country = country;
        this.weatherCode = weatherCode;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherInfo)) return false;
        WeatherInfo that = (WeatherInfo) o;
        return temperature == that.temperature && weatherCode == that.weatherCode && Objects.equals(city, that.city) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, city, country, weatherCode);
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "temperature=" + temperature +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", weatherCode=" + weatherCode +
                '}';
    }
}
