package com.example.weatherdetails;

import com.example.weatherdetails.configuration.WeatherApiConfiguration;
import com.example.weatherdetails.resources.WeatherApiResources;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

public class WeatherDetailsApplication extends Application<WeatherApiConfiguration> {
    public static void main(String[] args) throws Exception {
        new WeatherDetailsApplication().run(args);
    }

    @Override
    public void run(WeatherApiConfiguration configuration, Environment environment) {
        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfig())
                .build(getName());
        environment.jersey().register(new WeatherApiResources(client,
                configuration.getBaseUrl(), configuration.getPathUrl(),
                configuration.getToken()));
    }
}
