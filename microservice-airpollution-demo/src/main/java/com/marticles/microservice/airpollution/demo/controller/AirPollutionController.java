package com.marticles.microservice.airpollution.demo.controller;


import com.marticles.microservice.airpollution.demo.model.Pm25;
import com.marticles.microservice.airpollution.demo.model.Pollution;
import com.marticles.microservice.airpollution.demo.model.Site;
import com.marticles.microservice.airpollution.demo.service.ForecastService;
import com.marticles.microservice.airpollution.demo.service.HistoryService;
import com.marticles.microservice.airpollution.demo.service.SitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Marticles
 * @description PollutionController
 * @date 2019/1/13
 */
@Controller
public class AirPollutionController {

    @Autowired
    ForecastService forecastService;

    @Autowired
    HistoryService historyService;

    @Autowired
    SitesService sitesService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/history?site=jingan&startTime=2017-05-10%2008:00&endTime=2017-05-10%2013:00";
    }

    @RequestMapping("/history")
    public ModelAndView historyIndex(@RequestParam String site,
                                     @RequestParam String startTime,
                                     @RequestParam String endTime,
                                     Model model) {
        List<Pollution> pollutionList = historyService.getPollutionBySiteAndTime(site, startTime, endTime);
        List<Site> siteList = sitesService.getSites();
        if (null != pollutionList && null != siteList) {
            model.addAttribute("flag", "true");
        }
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("type", "history");
        model.addAttribute("selected_site", site);
        model.addAttribute("pollutionList", pollutionList);
        model.addAttribute("sites", siteList);
        model.addAttribute("info", pollutionList.get(0));
        return new ModelAndView("history", "pollutionModel", model);
    }

    @RequestMapping("/forecast")
    public ModelAndView forecastIndex(@RequestParam String site,
                                      @RequestParam String startTime,
                                      @RequestParam String endTime,
                                      Model model) {
        List<Pm25> forecastList = forecastService.getPm25BySiteAndTime(site, startTime, endTime);
        List<Site> siteList = sitesService.getSites();
        model.addAttribute("forecastList", forecastList);
        String request_site = "null";
        if (null != forecastList && null != siteList) {
            model.addAttribute("flag", "true");
            for (Site tmp : siteList) {
                if (tmp.getId().equals(site)) {
                    request_site = tmp.getName();
                }
            }
        }
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("type", "forecast");
        model.addAttribute("selected_site", site);
        model.addAttribute("sites", siteList);
        model.addAttribute("request_site", request_site);
        return new ModelAndView("forecast", "forecastModel", model);
    }

}
