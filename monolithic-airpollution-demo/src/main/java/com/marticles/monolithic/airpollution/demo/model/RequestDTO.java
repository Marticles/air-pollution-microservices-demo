package com.marticles.monolithic.airpollution.demo.model;

import lombok.Data;

/**
 * @author Marticles
 * @description RequestDTO
 * @date 2019/1/13
 */
@Data
public class RequestDTO {
    String site;
    String startTime;
    String endTime;
}
