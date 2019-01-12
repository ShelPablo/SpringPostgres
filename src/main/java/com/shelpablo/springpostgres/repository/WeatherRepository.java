package com.shelpablo.springpostgres.repository;

import com.shelpablo.springpostgres.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer> {
    List<WeatherEntity> findAllByCity(String city);
}
