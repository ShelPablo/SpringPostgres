package com.shelpablo.springpostgres.services;


import com.shelpablo.springpostgres.entity.WeatherEntity;
import com.shelpablo.springpostgres.repository.WeatherRepository;
import com.shelpablo.springpostgres.responses.AllCitiesResponse;
import com.shelpablo.springpostgres.responses.OneCityResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    WeatherRepository weatherRepository;
    @Getter
    private List<WeatherEntity> currentWeather = new ArrayList<>();

    public void addWeather(WeatherEntity weatherEntity) {
        weatherRepository.save(weatherEntity);
    }
    public void clearCurrentWeather() {
        currentWeather.clear();
    }
    public void addCurrentWeather(WeatherEntity weatherEntity) {
        currentWeather.add(weatherEntity);
    }

    public List<WeatherEntity> findAllByCity(String city){
        return weatherRepository.findAllByCity(city);
    }

    public List<AllCitiesResponse> getAllCitiesWeather() {
        List<AllCitiesResponse> list = new ArrayList<>();
        list.add(new AllCitiesResponse("Самара", 26, 95, "sunny"));
        list.add(new AllCitiesResponse("Москва", 27, 96, "cloudly"));
        list.add(new AllCitiesResponse("Санкт-Петербург", 16, 108, "rain"));
        return list;
    }

    public List<List<OneCityResponse>> getOneCityWeather(String city)
    {
        List<List<OneCityResponse>> response = new ArrayList<>();

        for(int i = 1; i <= 4; i++)
        {
            List<OneCityResponse> list = new ArrayList<>();
            for(int k = 0; k < 7; k++) {
                list.add(new OneCityResponse(
                        Integer.valueOf(i).toString(),
                        20 + i,
                        30 + i,
                        i*10 +k,
                        5 + i
                ));
            }
            response.add(list);
        }
        return response;
    }




}
