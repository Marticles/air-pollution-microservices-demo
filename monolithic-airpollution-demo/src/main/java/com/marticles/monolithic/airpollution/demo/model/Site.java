package com.marticles.monolithic.airpollution.demo.model;

import lombok.Data;

/**
 * @author Marticles
 * @description Site
 * @date 2019/1/13
 */
@Data
public class Site {
    public Site (String id,String name){
        this.id = id;
        this.name = name;
    }
    String id;
    String name;
}
