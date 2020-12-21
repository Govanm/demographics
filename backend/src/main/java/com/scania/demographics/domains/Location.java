package com.scania.demographics.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Project: demographics
 * Created on 2020-12-20.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String name;
    private String country;
    @JsonProperty("localtime_epoch")
    private long localTimeEpoch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getLocalTimeEpoch() {
        return localTimeEpoch;
    }

    public void setLocalTimeEpoch(long localTimeEpoch) {
        this.localTimeEpoch = localTimeEpoch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return localTimeEpoch == location.localTimeEpoch && Objects.equals(name, location.name) && Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, localTimeEpoch);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", localtime_epoch=" + localTimeEpoch +
                '}';
    }
}
