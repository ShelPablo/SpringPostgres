package com.shelpablo.springpostgres.controller;

import com.shelpablo.springpostgres.responses.AllCitiesResponse;
import com.shelpablo.springpostgres.responses.OneCityResponse;
import com.shelpablo.springpostgres.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
//@AllArgsConstructor(@__"Autowired")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/allCities")
    public List<AllCitiesResponse> getAllCitiesWeather() {
        return weatherService.getAllCitiesWeather();
    }

    @GetMapping("/oneCity/{city}")
    public List<List<OneCityResponse>> getOneCityWeather(@PathVariable("city") String city) {
        return weatherService.getOneCityWeather("city");
    }
}
