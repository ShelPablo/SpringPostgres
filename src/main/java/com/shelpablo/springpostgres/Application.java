package com.shelpablo.springpostgres;

import com.shelpablo.springpostgres.client.WeatherClient;
import com.shelpablo.springpostgres.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    @Autowired
    private WeatherService weatherService;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

}