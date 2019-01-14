package com.shelpablo.springpostgres.client;

import com.shelpablo.springpostgres.client.response.wind.Wind;
import com.shelpablo.springpostgres.client.response.wind.WindData;
import com.shelpablo.springpostgres.entity.WeatherEntity;
import com.shelpablo.springpostgres.services.WeatherService;
import com.shelpablo.springpostgres.client.response.temperature.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



import static com.shelpablo.springpostgres.configuration.Constants.*;

@Component
public class WeatherClient {
    @Autowired
    private WeatherService weatherService;

    private RestTemplate restTemplate = new RestTemplate();

/*
    @Scheduled(fixedRate = CLIENT_QUERY_PEROD_MS)
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

            Thread.sleep(CLIENT_QUERY_PAUSE_MS);

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
*/
    @Scheduled(fixedRate = CLIENT_QUERY_PEROD_MS)
    public void requestDataImitation() throws InterruptedException {
        weatherService.setCurrentWeather();
    }

/**
 * This function was used to fill database with random values for testing
 */
/*
    @PostConstruct
    public void fillDtabase() {
        LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 1, 0, 30);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", new Locale("ru", "RU"));

        List<WeatherEntity> list = new ArrayList<>();
        Arrays.stream(citiesRu).forEach(
                city->list.add(new WeatherEntity().setCity(city)));
        System.out.println("Start recording...");
        while (ldt.isBefore(LocalDateTime.of(
                2019, Month.FEBRUARY, 1, 0, 0))) {
            LocalDateTime ldt_final = LocalDateTime.of(ldt.toLocalDate(), ldt.toLocalTime());
            list.stream().map(w->w.setId(0L)
                        .setDatetime(ldt_final.format(dtf))
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
*/


}
