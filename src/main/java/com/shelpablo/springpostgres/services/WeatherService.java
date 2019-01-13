package com.shelpablo.springpostgres.services;


import com.shelpablo.springpostgres.entity.WeatherEntity;
import com.shelpablo.springpostgres.repository.WeatherRepository;
import com.shelpablo.springpostgres.responses.AllCitiesResponse;
import com.shelpablo.springpostgres.responses.OneCityResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.shelpablo.springpostgres.configuration.Constants.*;

@Service
public class WeatherService {
    @Autowired
    WeatherRepository weatherRepository;
    @Getter
    private List<WeatherEntity> currentWeather = new ArrayList<>();

    public void setCurrentWeather() {
        currentWeather =
            weatherRepository.findWeatherAtDateHour(LocalDateTime.now().format(YMD_H));
    }


    public void addWeather(WeatherEntity weatherEntity) {
        weatherRepository.save(weatherEntity);
    }

    public void clearCurrentWeather() {
        currentWeather.clear();
    }

    public void addCurrentWeather(WeatherEntity weatherEntity) {
        currentWeather.add(weatherEntity);
    }

    public List<WeatherEntity> findAllByCity(String city) {
        return weatherRepository.findAllByCity(city);
    }

    public List<AllCitiesResponse> getAllCitiesWeather() {
        List<AllCitiesResponse> allCitiesResponses = new ArrayList<>();
        currentWeather.forEach(w -> allCitiesResponses.add(
                AllCitiesResponse.getFromWeatherEntity(w)));
        return allCitiesResponses;
    }

    public List<List<OneCityResponse>> getOneCityWeather(String city) {
        return splitIntoWeeks(
                weatherRepository.findAllWeathersInCityAfterDate(city,
                            LocalDateTime.now().minusDays(DAYS_FOR_ONE_CITY-1).format(YMD_HM).toString()).stream()
                        .filter(w->w.getDatetime().compareTo(LocalDateTime.now().format(YMD_HM))<0)
                        .collect(Collectors.groupingBy(w -> w.getDatetime().substring(0, 10)))
                        .entrySet().stream()
                        .map(e -> new OneCityResponse(e.getKey(),
                                getMinT.apply(e.getValue()),
                                getMaxT.apply(e.getValue()),
                                getMinWindSpeed.apply(e.getValue()),
                                getMaxWindSpeed.apply(e.getValue()))
                        )
                        .sorted(Comparator.comparing(OneCityResponse::getDate))
                        .map(ocr->ocr.setDate(ocr.getDate().substring(8, 10)
                                + "."
                                + ocr.getDate().substring(5, 7)))
                        .collect(Collectors.toList())
        );
    }

    public List<WeatherEntity> getAllWeathersInCityAfterDate(String city, String date) {
        return weatherRepository.findAllWeathersInCityAfterDate(city, date);
    }


    private Function<List<WeatherEntity>, Integer> getMaxT = wList -> wList.stream()
            .map(WeatherEntity::getTemperatureC)
            .max(Integer::compare)
            .orElse(null);
    private Function<List<WeatherEntity>, Integer> getMinT = wList -> wList.stream()
            .map(WeatherEntity::getTemperatureC)
            .min(Integer::compare)
            .orElse(null);
    private Function<List<WeatherEntity>, Integer> getMaxWindSpeed = wList -> wList.stream()
            .map(WeatherEntity::getWindSpeed)
            .max(Integer::compare)
            .orElse(null);
    private Function<List<WeatherEntity>, Integer> getMinWindSpeed = wList -> wList.stream()
            .map(WeatherEntity::getWindSpeed)
            .min(Integer::compare)
            .orElse(null);

    private List<List<OneCityResponse>> splitIntoWeeks(List<OneCityResponse> oneCityMonthWeather) {
        List<List<OneCityResponse>> response = new ArrayList<>();
        for (int i = 0; i < oneCityMonthWeather.size() / DAYS_IN_WEEK; i++) {
            response.add(oneCityMonthWeather.subList(i * DAYS_IN_WEEK, (i + 1) * DAYS_IN_WEEK));
        }
        return response;
    }


}
