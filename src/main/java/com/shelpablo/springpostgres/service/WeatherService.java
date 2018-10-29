package com.shelpablo.springpostgres.service;


import com.shelpablo.springpostgres.entity.Weather;
import com.shelpablo.springpostgres.repository.WeatherRepository;
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
    private List<Weather> currentWeather = new ArrayList<>();

    public void addWeather(Weather weather) {
        weatherRepository.save(weather);
    }
    public void clearCurrentWeather() {
        currentWeather.clear();
    }
    public void addCurrentWeather(Weather weather) {
        currentWeather.add(weather);
    }

    public List<Weather> findAllByCountry(String country){
        return weatherRepository.findAllByCountry(country);
    }



}
