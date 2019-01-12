package com.shelpablo.springpostgres.client;

import com.shelpablo.springpostgres.entity.WeatherEntity;
import com.shelpablo.springpostgres.client.response.temperature.Example;
import com.shelpablo.springpostgres.client.response.wind.Wind;
import com.shelpablo.springpostgres.client.response.wind.WindData;
import com.shelpablo.springpostgres.services.WeatherService;
import org.apache.coyote.http2.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.ThreadLocalRandom.*;

@Component
public class WeatherClient {
    private static final String[] cities = {"moscow", "samara", "saint-petersburg"};
    private static final String[] citiesRu = {"Москва", "Самара", "Санкт-Петербург"};

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

    private RestTemplate restTemplate = new RestTemplate();

    //    @Scheduled(fixedRate = 3600*1000)
    public void requestData() throws InterruptedException {

        weatherService.clearCurrentWeather();

        for (String city : cities) {
            WindData windData = restTemplate.getForObject(getQueryForWindIn(city), WindData.class);
            Wind wind = windData.getQuery().getResults().getChannel().getWind();

            WeatherEntity weatherEntity = new WeatherEntity();

            weatherEntity.setWindChill(Integer.parseInt(wind.getChill()))
                    .setWindDirection(Integer.parseInt(wind.getDirection()))
                    .setWindSpeed(Integer.parseInt(wind.getSpeed()))
                    .setCity(city);

            Thread.sleep(1000);

            Example example = restTemplate.getForObject(getQueryForTemperatureIn(city), Example.class);

            weatherEntity.setTemperatureC(Integer.parseInt(example.getQuery()
                    .getResults()
                    .getChannel()
                    .getItem()
                    .getCondition()
                    .getTemp()));

            System.out.println("weatherEntity:  " + weatherEntity);
            weatherService.addWeather(weatherEntity);
        }
    }


    //@PostConstruct
    public void fillDtabase() {
        LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 1, 0, 0);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm");

        List<WeatherEntity> list = new ArrayList<>();
        Arrays.stream(citiesRu).forEach(
                city->list.add(new WeatherEntity().setCity(city)));
        System.out.println("Start recording...");
        while (ldt.isBefore(LocalDateTime.of(
                2019, Month.FEBRUARY, 1, 0, 0))) {
            LocalDateTime ldt_final = LocalDateTime.of(ldt.toLocalDate(), ldt.toLocalTime());
            list.stream().map(w->w.setId(0L)
                        .setDatetime(ldt_final.format(dtf).toString())
                        .setTemperatureC(current().nextInt(-20, 36))
                        .setWindChill(current().nextInt(-20, 21))
                        .setWindSpeed(current().nextInt(0, 21))
                        .setWindDirection(current().nextInt(-180, 181)))
                    .peek(System.out::println)
                    .forEach(weatherService::addWeather);
             ldt = ldt.plusHours(1L);

        }
        System.out.println("Successfully recorded!");


    }




}
