package com.marticles.microservice.airpollution.demo.service;

import com.marticles.microservice.airpollution.demo.model.Site;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Marticles
 * @description SitesService
 * @date 2019/1/14
 */
@FeignClient("microservice-airpollution-zuul-gateway")
public interface SitesService {

    @GetMapping("/api/v1/sites/site")
    List<Site> getSites();

}
