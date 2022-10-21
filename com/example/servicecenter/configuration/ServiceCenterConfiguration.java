package com.example.servicecenter.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ServiceCenterConfiguration extends Configuration {
    @Valid
    @NotNull
    private DataSourceFactory factory = new DataSourceFactory();

    @JsonProperty("database")
    public void setFactory(DataSourceFactory factory) {
        this.factory = factory;
    }

    @JsonProperty("database")
    public DataSourceFactory getFactory() {
        return this.factory;
    }
}
