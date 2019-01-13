package com.shelpablo.springpostgres.configuration;

import java.net.URI;
import java.time.format.DateTimeFormatter;

public class Constants {
    public static URI getQueryForTemperatureIn(String city) {
        return URI.create(
                "https://query.yahooapis.com/v1/public/yql?q=select%20" +
                        "item.condition%20from%20weather.forecast%20where%20" +
                        "woeid%20%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" +
                        city + "%2C%20ru%22)&" +
                        "format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
    }


    public static URI getQueryForWindIn(String city) {
        return URI.create(
                "https://query.yahooapis.com/v1/public/yql?q=select%20" +
                        "wind%20from%20weather.forecast%20where%20" +
                        "woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" +
                        city + "%2C%20ru%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
    }

    public static final int DAYS_FOR_ONE_CITY = 28;
    public static final int HOURS_IN_DAY = 24;
    public static final int DAYS_IN_WEEK = 7;
    public static final int CLIENT_QUERY_PEROD_MS = 3600*1000;
    public static final int CLIENT_QUERY_PAUSE_MS = 1000;

    public static final DateTimeFormatter YMD_HM =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter YMD_H =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
    public static final DateTimeFormatter DM =
            DateTimeFormatter.ofPattern("dd.MM");

    public static final String[] cities = {"moscow", "samara", "saint-petersburg"};
    public static final String[] citiesRu = {"Москва", "Самара", "Санкт-Петербург"};



}
