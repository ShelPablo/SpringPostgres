package com.shelpablo.springpostgres.controller;

import com.shelpablo.springpostgres.entity.Weather;
import com.shelpablo.springpostgres.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService service;

    @RequestMapping()
    public String index(){
        return "index";
    }
//    @GetMapping
//    public List<Weather> index(){
//        return service.getCurrentWeather();
//    }
}

