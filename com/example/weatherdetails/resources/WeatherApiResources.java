package com.example.weatherdetails.resources;

import com.example.weatherdetails.configuration.WeatherApiConfiguration;
import com.example.weatherdetails.model.WeatherDetails;
import io.dropwizard.client.HttpClientConfiguration;
import io.dropwizard.hibernate.UnitOfWork;
import org.apache.http.impl.client.CloseableHttpClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/weather-details")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherApiResources {
    private final Client client;
    private final String baseUrl;
    private final String pathUrl;
    private final String token;

    public WeatherApiResources(Client client, String baseUrl, String pathUrl, String token) {
        this.client = client;
        this.baseUrl = baseUrl;
        this.pathUrl = pathUrl;
        this.token = token;
    }

    @GET
    @Path("")
    public WeatherDetails getWeatherDetails() {
        System.out.println(token);
        WebTarget webTarget = client.target(baseUrl + pathUrl + token);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        return response.readEntity(WeatherDetails.class);
    }
}
