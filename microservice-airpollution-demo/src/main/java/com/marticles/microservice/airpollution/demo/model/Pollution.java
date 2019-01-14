package com.marticles.microservice.airpollution.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Marticles
 * @description Pollution
 * @date 2019/1/13
 */
@Data
public class Pollution {
    Float oZone1Hour;
    Float aqi;
    String level;
    Float co;
    Date time;
    Float so2;
    String city;
    String site;
    String primaryPollutant;
    Float oZone8Hour;
    Float no2;
    Float pm10;
    Float pm25;
}
