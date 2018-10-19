package com.shelpablo.springpostgres.service;


import com.shelpablo.springpostgres.entity.Weather;
import com.shelpablo.springpostgres.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    WeatherRepository weatherRepository;

    public void addWeather(Weather weather) {weatherRepository.save(weather);}

    public List<Weather> findAllByCountry(String country){
        return weatherRepository.findAllByCountry(country);
    }

}
