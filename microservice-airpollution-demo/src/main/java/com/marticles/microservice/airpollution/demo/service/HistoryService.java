package com.marticles.microservice.airpollution.demo.service;

import com.marticles.microservice.airpollution.demo.model.Pollution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Marticles
 * @description HistoryService
 * @date 2019/1/14
 */
@FeignClient(value = "microservice-airpollution-zuul-gateway", fallback = HistoryService.HistoryFallBackService.class)
public interface HistoryService {

    @GetMapping("/api/v1/history/pollution")
    List<Pollution> getPollutionBySiteAndTime(@RequestParam("site") String site,
                                              @RequestParam("startTime") String startTime,
                                              @RequestParam("endTime") String endTime);

    @Slf4j
    @Component
    class HistoryFallBackService implements HistoryService {
        @Override
        public List<Pollution> getPollutionBySiteAndTime(@RequestParam("site") String site,
                                                         @RequestParam("startTime") String startTime,
                                                         @RequestParam("endTime") String endTime) {
            log.error("***********************************");
            log.error("Pollution History service was disable!");
            log.error("***********************************");
            return null;
        }
    }
}
