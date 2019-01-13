package com.shelpablo.springpostgres.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OneCityResponse {
    String date;// "01.01",
    int tmin;
    int tmax;
    int windSpeedMin;
    int windSpeedMax;

    public OneCityResponse setDate(String date) {
        this.date = date;
        return this;
    }


}
