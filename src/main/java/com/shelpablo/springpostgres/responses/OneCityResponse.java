package com.shelpablo.springpostgres.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OneCityResponse {
    String date;// "01.01",
    int tmin;// 26,
    int tmax;//: 35,
    int windSpeedMin; //: 11,
    int windSpeedMax;//: 12
}
