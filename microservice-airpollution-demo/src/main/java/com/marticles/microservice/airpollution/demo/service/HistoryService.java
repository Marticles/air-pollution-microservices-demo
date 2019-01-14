package com.marticles.microservice.airpollution.demo.service;

import com.marticles.microservice.airpollution.demo.model.Pollution;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Marticles
 * @description HistoryService
 * @date 2019/1/14
 */
@FeignClient("microservice-airpollution-history-server")
public interface HistoryService {

    @GetMapping("/api/history")
    List<Pollution> getPollutionBySiteAndTime(@RequestParam("site") String site ,
                                              @RequestParam("startTime") String startTime,
                                              @RequestParam("endTime") String endTime);
}
