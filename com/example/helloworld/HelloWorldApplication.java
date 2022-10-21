package com.example.helloworld;

import com.example.helloworld.configuration.HelloWorldConfiguration;
import com.example.helloworld.resourses.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception{
        new HelloWorldApplication().run(args);
    }

//    @Override
//    public String getName() {
//        return "config";
//    }

//    @Override
//    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
//    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);
    }
}
