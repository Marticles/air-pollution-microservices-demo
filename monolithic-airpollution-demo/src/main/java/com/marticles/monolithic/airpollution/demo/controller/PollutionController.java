package com.marticles.monolithic.airpollution.demo.controller;

import com.marticles.monolithic.airpollution.demo.model.Pm25;
import com.marticles.monolithic.airpollution.demo.model.Pollution;
import com.marticles.monolithic.airpollution.demo.model.Site;
import com.marticles.monolithic.airpollution.demo.service.PollutionService;
import com.marticles.monolithic.airpollution.demo.util.Sites;
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
public class PollutionController {

    @Autowired
    PollutionService pollutionService;

    @RequestMapping("/history")
    public ModelAndView historyIndex(@RequestParam String site,
                                     @RequestParam String startTime,
                                     @RequestParam String endTime,
                                     Model model) {
        List<Pollution> pollutionList = pollutionService.getPollutionBySiteAndTime(site, startTime, endTime);
        if (pollutionList.size() != 0) {
            model.addAttribute("flag", "true");
        }
        model.addAttribute("pollutionList", pollutionList);
        model.addAttribute("sites", Sites.getSites());
        model.addAttribute("info", pollutionList.get(0));
        return new ModelAndView("history", "pollutionModel", model);
    }

    @RequestMapping("/forecast")
    public ModelAndView forecastIndex(@RequestParam String site,
                                      @RequestParam String startTime,
                                      @RequestParam String endTime,
                                      Model model) {
        List<Pm25> forecastList = pollutionService.getPm25BySiteAndTime(site, startTime, endTime);
        model.addAttribute("forecastList", forecastList);
        if (forecastList.size() != 0) {
            model.addAttribute("flag", "true");
        }
        List<Site> sites = Sites.getSites();
        String request_site = "NULL";
        for (Site tmp : sites) {
            if (tmp.getId().equals(site)) {
                request_site = tmp.getName();
            }
        }
        model.addAttribute("sites", sites);
        model.addAttribute("request_site", request_site);
        return new ModelAndView("forecast", "forecastModel", model);
    }

}
