package com.shelpablo.springpostgres.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weather", schema = "public", catalog = "weather_shelest")
public class WeatherEntity {
    private long id;
    private String datetime;
    private String city;
    private Integer temperatureC;
    private Integer windChill;
    private Integer windDirection;
    private Integer windSpeed;

    @Id
    @SequenceGenerator( name = "jpaSequence", sequenceName = "weather_id_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public WeatherEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "datetime", nullable = true, length = 16)
    public String getDatetime() {
        return datetime;
    }

    public WeatherEntity setDatetime(String datetime) {
        this.datetime = datetime;
        return this;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 32)
    public String getCity() {
        return city;
    }

    public WeatherEntity setCity(String city) {
        this.city = city;
        return this;
    }

    @Basic
    @Column(name = "temperature_c", nullable = true)
    public Integer getTemperatureC() {
        return temperatureC;
    }

    public WeatherEntity setTemperatureC(Integer temperatureC) {
        this.temperatureC = temperatureC;
        return this;
    }

    @Basic
    @Column(name = "wind_chill", nullable = true)
    public Integer getWindChill() {
        return windChill;
    }

    public WeatherEntity setWindChill(Integer windChill) {
        this.windChill = windChill;
        return this;
    }

    @Basic
    @Column(name = "wind_direction", nullable = true)
    public Integer getWindDirection() {
        return windDirection;
    }

    public WeatherEntity setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
        return this;
    }

    @Basic
    @Column(name = "wind_speed", nullable = true)
    public Integer getWindSpeed() {
        return windSpeed;
    }

    public WeatherEntity setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntity weatherEntity = (WeatherEntity) o;
        return id == weatherEntity.id &&
                Objects.equals(datetime, weatherEntity.datetime) &&
                Objects.equals(city, weatherEntity.city) &&
                Objects.equals(temperatureC, weatherEntity.temperatureC) &&
                Objects.equals(windChill, weatherEntity.windChill) &&
                Objects.equals(windDirection, weatherEntity.windDirection) &&
                Objects.equals(windSpeed, weatherEntity.windSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datetime, city, temperatureC, windChill, windDirection, windSpeed);
    }


    @Override
    public String toString() {
        return "WeatherEntity{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", city='" + city + '\'' +
                ", temperatureC=" + temperatureC +
                ", windChill=" + windChill +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                '}';
    }

}
