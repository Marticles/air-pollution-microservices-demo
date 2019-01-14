package com.marticles.microservice.airpollution.demo.service;

import com.marticles.microservice.airpollution.demo.model.Pm25;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Marticles
 * @description ForecastService
 * @date 2019/1/14
 */
@FeignClient("microservice-airpollution-zuul-gateway")
public interface ForecastService {

    @GetMapping("/api/v1/forecast/pm25")
    List<Pm25> getPm25BySiteAndTime(@RequestParam("site") String site ,
                                    @RequestParam("startTime") String startTime,
                                    @RequestParam("endTime") String endTime);
}
