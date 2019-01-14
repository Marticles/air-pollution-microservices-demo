package com.marticles.microservice.airpollution.demo.service;

import com.marticles.microservice.airpollution.demo.model.Pm25;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Marticles
 * @description ForecastService
 * @date 2019/1/14
 */
@FeignClient(value = "microservice-airpollution-zuul-gateway",fallback = ForecastService.ForecastFallBackService.class)
public interface ForecastService {

    @GetMapping("/api/v1/forecast/pm25")
    List<Pm25> getPm25BySiteAndTime(@RequestParam("site") String site ,
                                    @RequestParam("startTime") String startTime,
                                    @RequestParam("endTime") String endTime);

    @Slf4j
    @Component
    class ForecastFallBackService implements ForecastService {
        @Override
        public List<Pm25> getPm25BySiteAndTime(@RequestParam("site") String site ,
                                               @RequestParam("startTime") String startTime,
                                               @RequestParam("endTime") String endTime) {
            log.error("***********************************");
            log.error("PM2.5 forecast service was disable!");
            log.error("***********************************");
            return null;
        }
    }
}


