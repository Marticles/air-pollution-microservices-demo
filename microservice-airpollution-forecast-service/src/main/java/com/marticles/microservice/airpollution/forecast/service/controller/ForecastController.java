package com.marticles.microservice.airpollution.forecast.service.controller;

import com.marticles.microservice.airpollution.forecast.service.model.Pm25;
import com.marticles.microservice.airpollution.forecast.service.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Marticles
 * @description ForecastController
 * @date 2019/1/14
 */
@RestController
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    @RequestMapping("/api/forecast")
    public List<Pm25> history(@RequestParam String site,
                              @RequestParam String startTime,
                              @RequestParam String endTime) {
        List<Pm25> pm25List = forecastService.getPm25BySiteAndTime(site, startTime, endTime);
        return pm25List;
    }
}
