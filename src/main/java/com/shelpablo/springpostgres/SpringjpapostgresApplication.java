package com.shelpablo.springpostgres;

import com.shelpablo.springpostgres.client.WeatherClient;
import com.shelpablo.springpostgres.entity.Address;
import com.shelpablo.springpostgres.entity.Users;
import com.shelpablo.springpostgres.entity.Weather;
import com.shelpablo.springpostgres.service.UserService;
import com.shelpablo.springpostgres.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringjpapostgresApplication {

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SpringjpapostgresApplication.class, args)
                .getBean(WeatherClient.class).requestData();


    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods(){
//        Address address = new Address();
//        address.setCity("Kiev");
//        address.setHomeNumber("4");
//        address.setStreet("Main Street");
//        Address address1 = new Address();
//        address1.setCity("Lviv");
//        Users users = new Users();
//        users.setAddress(address);
//        users.setEmail("someEmail@gmail.com");
//        users.setName("Smith");
//        userService.createUsers(users);
//        Users users1 = new Users();
//        users1.setName("Jon Dorian");
//        users1.setEmail("gmailEmail@gmail.com");
//        users1.setAddress(address1);
//        userService.createUsers(users1);
//
//        userService.findAll().forEach(it-> System.out.println(it));
//
//        userService.findAllByName("Smith").forEach(it-> System.out.println(it));
//
//        userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));
//
//        userService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));





//        weatherService.findAllByCountry("Russia").forEach(x-> System.out.println(x.getCity()));




//        weatherService.addWeather(weather);

    }
}