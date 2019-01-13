package com.shelpablo.springpostgres.repository;

import com.shelpablo.springpostgres.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    List<WeatherEntity> findAllByCity(String city);

    @Query(value = "SELECT w FROM WeatherEntity w WHERE w.city = ?1 AND w.datetime > ?2")
    List<WeatherEntity> findAllWeathersInCityAfterDate(String city, String date);

    @Query("SELECT w FROM WeatherEntity w WHERE w.datetime LIKE CONCAT(?1, '%')")
    List<WeatherEntity> findWeatherAtDateHour(String currentDateHour);

}
