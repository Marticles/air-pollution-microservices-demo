package com.marticles.microservice.airpollution.history.service.controller;

import com.marticles.microservice.airpollution.history.service.model.Pollution;
import com.marticles.microservice.airpollution.history.service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Marticles
 * @description HistoryController
 * @date 2019/1/14
 */
@RestController
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @RequestMapping("/api/history")
    public List<Pollution> history(@RequestParam String site,
                                     @RequestParam String startTime,
                                     @RequestParam String endTime) {
        List<Pollution> pollutionList = historyService.getPollutionBySiteAndTime(site, startTime, endTime);
        return pollutionList;
    }
}
