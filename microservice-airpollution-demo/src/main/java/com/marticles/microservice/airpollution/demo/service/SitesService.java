package com.marticles.microservice.airpollution.demo.service;

import com.marticles.microservice.airpollution.demo.model.Site;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Marticles
 * @description SitesService
 * @date 2019/1/14
 */
@FeignClient(value = "microservice-airpollution-zuul-gateway",fallback = SitesService.SitesFallBackService.class)
public interface SitesService {

    @GetMapping("/api/v1/sites/site")
    List<Site> getSites();

    @Slf4j
    @Component
    class SitesFallBackService implements SitesService {
        @Override
        public List<Site> getSites() {
            log.error("***********************************");
            log.error("Sites service was disable!");
            log.error("***********************************");
            return null;
        }
    }

}
