package com.shelpablo.springpostgres.responses;

import com.shelpablo.springpostgres.entity.WeatherEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AllCitiesResponse {
    private String city;
    private Integer temp;
    private Integer windChill;
    private Integer windDir;
    private Integer windSpeed;

    public static AllCitiesResponse getFromWeatherEntity(WeatherEntity weatherEntity)
    {
        return new AllCitiesResponse(
                weatherEntity.getCity(),
                weatherEntity.getTemperatureC(),
                weatherEntity.getWindChill(),
                weatherEntity.getWindDirection(),
                weatherEntity.getWindSpeed()
        ) ;
    }
}
