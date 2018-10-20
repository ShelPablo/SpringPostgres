package com.shelpablo.springpostgres.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Weather {
    private long id;
    private Timestamp dategmt;
    private String country;
    private String city;
    private Integer temperatureC;
    private Integer windChill;
    private Integer windDirection;
    private Integer windSpeed;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public Weather setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "dategmt")
    public Timestamp getDategmt() {
        return dategmt;
    }

    public Weather setDategmt(Timestamp dategmt) {
        this.dategmt = dategmt;
        return this;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public Weather setCountry(String country) {
        this.country = country;
        return this;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public Weather setCity(String city) {
        this.city = city;
        return this;
    }

    @Basic
    @Column(name = "temperature_c")
    public Integer getTemperatureC() {
        return temperatureC;
    }

    public Weather setTemperatureC(Integer temperatureC) {
        this.temperatureC = temperatureC;
        return this;
    }

    @Basic
    @Column(name = "wind_chill")
    public Integer getWindChill() {
        return windChill;
    }

    public Weather setWindChill(Integer windChill) {
        this.windChill = windChill;
        return this;
    }

    @Basic
    @Column(name = "wind_direction")
    public Integer getWindDirection() {
        return windDirection;
    }

    public Weather setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
        return this;
    }

    @Basic
    @Column(name = "wind_speed")
    public Integer getWindSpeed() {
        return windSpeed;
    }

    public Weather setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return id == weather.id &&
                Objects.equals(dategmt, weather.dategmt) &&
                Objects.equals(country, weather.country) &&
                Objects.equals(city, weather.city) &&
                Objects.equals(temperatureC, weather.temperatureC) &&
                Objects.equals(windChill, weather.windChill) &&
                Objects.equals(windDirection, weather.windDirection) &&
                Objects.equals(windSpeed, weather.windSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dategmt, country, city, temperatureC, windChill, windDirection, windSpeed);
    }


    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", dategmt=" + dategmt +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", temperatureC=" + temperatureC +
                ", windChill=" + windChill +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                '}';
    }

}
