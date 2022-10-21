package com.example.weatherdetails.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WeatherApiConfiguration extends Configuration {
    @Valid
    @NotNull
    private JerseyClientConfiguration jerseyClient = new JerseyClientConfiguration();

    @NotEmpty
    private String baseUrl;

    @NotEmpty
    private String pathUrl;

    @NotEmpty
    private String token;

    @JsonProperty
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @JsonProperty
    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    @JsonProperty
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty
    public String getPathUrl() {
        return pathUrl;
    }

    @JsonProperty
    public String getToken() {
        return token;
    }

    @JsonProperty("jerseyClient")
    public JerseyClientConfiguration getJerseyClientConfig() {
        return this.jerseyClient;
    }

    @JsonProperty("jerseyClient")
    public void setHttpClient(JerseyClientConfiguration jerseyClient) {
        this.jerseyClient = jerseyClient;
    }
}
