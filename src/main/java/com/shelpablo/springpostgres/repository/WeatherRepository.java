package com.shelpablo.springpostgres.repository;

import com.shelpablo.springpostgres.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> findAllByCity(String city);
}
