package com.marticles.microservice.airpollution.forecast.service.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Marticles
 * @description Pm25
 * @date 2019/1/13
 */
@Data
public class Pm25 {
    Double forecastPm25;
    Date time;
}
