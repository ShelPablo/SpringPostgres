package com.shelpablo.springpostgres.client;

import com.shelpablo.springpostgres.entity.Weather;
import com.shelpablo.springpostgres.response.temperature.Example;
import com.shelpablo.springpostgres.response.wind.Wind;
import com.shelpablo.springpostgres.response.wind.WindData;
import com.shelpablo.springpostgres.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class WeatherClient {
    private static final String[] cities = {"moscow", "samara", "saint-petersburg"};

    private static URI getQueryForTemperatureIn(String city) {
        return URI.create(
                "https://query.yahooapis.com/v1/public/yql?q=select%20" +
                        "item.condition%20from%20weather.forecast%20where%20" +
                        "woeid%20%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" +
                        city + "%2C%20ru%22)&" +
                        "format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
    }



    private static URI getQueryForWindIn(String city) {
        return URI.create(
                "https://query.yahooapis.com/v1/public/yql?q=select%20" +
                        "wind%20from%20weather.forecast%20where%20" +
                        "woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" +
                        city + "%2C%20ru%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
    }

    @Autowired
    private WeatherService weatherService;

    public void requestData() throws InterruptedException {

        RestTemplate restTemplate = new RestTemplate();

        while (true) {

            for (String city : cities) {
                WindData windData = restTemplate.getForObject(getQueryForWindIn(city), WindData.class);
                Wind wind = windData.getQuery().getResults().getChannel().getWind();

                Weather weather = new Weather();

                weather.setWindChill(Integer.parseInt(wind.getChill()))
                        .setWindDirection(Integer.parseInt(wind.getDirection()))
                        .setWindSpeed(Integer.parseInt(wind.getSpeed()))
                        .setCountry("ru")
                        .setCity(city);

                Thread.sleep(1000);

                Example example = restTemplate.getForObject(getQueryForTemperatureIn(city), Example.class);

                weather.setTemperatureC(Integer.parseInt(example.getQuery()
                        .getResults()
                        .getChannel()
                        .getItem()
                        .getCondition()
                        .getTemp()));

                System.out.println("weather:  " + weather);
                weatherService.addWeather(weather);
            }
            Thread.sleep(20000);
        }

    }

}
