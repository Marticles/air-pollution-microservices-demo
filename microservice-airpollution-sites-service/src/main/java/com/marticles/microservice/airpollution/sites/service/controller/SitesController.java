package com.marticles.microservice.airpollution.sites.service.controller;

import com.marticles.microservice.airpollution.sites.service.model.Site;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marticles
 * @description SitesController
 * @date 2019/1/14
 */
@RestController
public class SitesController {

    @RequestMapping("/site")
    public List<Site> sites(){
        return getSites();
    }

    private List<Site> getSites(){
        List<Site> sites = new ArrayList<>();
        sites.add(new Site("jingan","静安"));
        sites.add(new Site("yangpusipiao","杨浦"));
        sites.add(new Site("hongkou","虹口"));
        sites.add(new Site("pudongxinqu","浦东新区"));
        sites.add(new Site("pudongchuansha","浦东川沙"));
        sites.add(new Site("putuo","普陀"));
        sites.add(new Site("qingpudianshanhu","青浦淀山湖"));
        return sites;
    }

}
