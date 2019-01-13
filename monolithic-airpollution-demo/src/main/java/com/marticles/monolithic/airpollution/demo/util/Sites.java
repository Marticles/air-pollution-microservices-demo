package com.marticles.monolithic.airpollution.demo.util;

import com.marticles.monolithic.airpollution.demo.model.Site;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marticles
 * @description Sites
 * @date 2019/1/13
 */
public class Sites {
    public static List<Site> getSites(){
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
