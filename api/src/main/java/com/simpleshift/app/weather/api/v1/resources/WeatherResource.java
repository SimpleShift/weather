package com.simpleshift.app.weather.api.v1.resources;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.*;
import java.io.StringReader;

@ApplicationScoped
@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WeatherResource {

    private Client httpClient;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    @GET
    public Response getWeather(@QueryParam("lat") String lat, @QueryParam("lon") String lon) {
        if (lat == null || lon == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            String response = darkskyAPI(lat, lon);

            JsonReader jsonReader = Json.createReader(new StringReader(response));
            JsonObject object = jsonReader.readObject();
            jsonReader.close();

            String summary = object.getJsonObject("currently").getJsonString("summary").getString();
            Double tempF = object.getJsonObject("currently").getJsonNumber("temperature").doubleValue();
            Double tempC = ((tempF - 32)*5)/9;

            String ret = String.format("%s (%.0f °C)", summary, tempC);

            return Response.status(Response.Status.OK).entity(ret).build();
        }
    }

    private String darkskyAPI(String lat, String lon) {
        try {
            return httpClient
                    .target("https://api.darksky.net/forecast/a3fac864bd63b7bf93e6c00b9c6d85ca/" + lat + "," + lon)
                    .request().get(String.class);
        } catch (WebApplicationException | ProcessingException e) {
            throw new InternalServerErrorException(e);
        }
    }
}