package com.example.weatherdetails.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDetails {
    private final String base;
    private final Integer visibility;

    public WeatherDetails(@JsonProperty("base") String base,
                          @JsonProperty("visibility") Integer visibility) {
        this.base = base;
        this.visibility = visibility;
    }

    @JsonProperty
    public String getBase() {
        return this.base;
    }

    @JsonProperty
    public Integer getVisibility() {
        return this.visibility;
    }
}
