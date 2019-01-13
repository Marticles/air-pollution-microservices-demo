package com.marticles.monolithic.airpollution.demo;

import com.marticles.monolithic.airpollution.demo.service.PollutionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonolithicAirpollutionDemoApplicationTests {

    @Autowired
    PollutionService pollutionService;

    @Test
    public void contextLoads() throws ParseException {
    }

    @Test
    public void test() throws ParseException {

        // 历史数据
//        String startTime = "2018-02-10 10:00";
//        String endTime = "2018-02-11 20:00";

        // 预测数据
        String startTime = "2019-01-10 10:00";
        String endTime = "2019-01-11 20:00";

        pollutionService.getPm25BySiteAndTime("jingan",startTime,endTime);
    }

}

