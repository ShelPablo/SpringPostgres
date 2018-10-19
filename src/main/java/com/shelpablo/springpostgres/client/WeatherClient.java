package com.shelpablo.springpostgres.client;

import com.shelpablo.springpostgres.response.WeatherData;
import com.shelpablo.springpostgres.response.Wind;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class WeatherClient {
    private static final URI URL_WEATHER = URI.create("https://query.yahooapis.com/v1/public/yql?q=select%20wind%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22chicago%2C%20il%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");

    public void requestData() throws InterruptedException {

        while (true) {

            RestTemplate restTemplate = new RestTemplate();

            // Send request with GET method and default Headers.
            WeatherData weatherData = restTemplate.getForObject(URL_WEATHER, WeatherData.class);

            Wind wind = weatherData.getQuery().getResults().getChannel().getWind();

            if (weatherData != null) {
                System.out.println("chill: " + wind.getChill());
                System.out.println("dir: " + wind.getDirection());
                System.out.println("speed: " + wind.getSpeed()+'\n');
            }

            Thread.sleep(3000);
        }

    }


}
