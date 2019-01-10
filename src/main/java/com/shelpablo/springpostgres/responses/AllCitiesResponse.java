package com.shelpablo.springpostgres.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AllCitiesResponse {
    String city;
    int temp;
    int windDir;
    String cloudness;
}
