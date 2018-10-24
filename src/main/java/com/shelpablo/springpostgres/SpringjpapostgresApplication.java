package com.shelpablo.springpostgres;

import com.shelpablo.springpostgres.client.WeatherClient;
import com.shelpablo.springpostgres.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringjpapostgresApplication {

    @Autowired
    private WeatherService weatherService;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SpringjpapostgresApplication.class, args)
                .getBean(WeatherClient.class).requestData();
    }

}