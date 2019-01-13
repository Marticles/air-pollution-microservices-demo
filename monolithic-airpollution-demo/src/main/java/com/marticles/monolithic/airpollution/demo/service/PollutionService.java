package com.marticles.monolithic.airpollution.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.marticles.monolithic.airpollution.demo.model.Pm25;
import com.marticles.monolithic.airpollution.demo.model.Pollution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Marticles
 * @description PollutionService
 * @date 2019/1/13
 */
@Slf4j
@Service
public class PollutionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public List<Pollution> getPollutionBySiteAndTime(String site, String startTime, String endTime) {
        String url = "http://airnet.ink/api/history/" + site + "/all?start=" + startTime + "&end=" + endTime;
        JSONObject pollutionJson = null;
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        // 如果Redis中存在缓存
        if (stringRedisTemplate.hasKey(url)) {
            pollutionJson = JSON.parseObject(valueOperations.get(url));
            // 否则调用API获取
        } else {
            ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
            if (entity.getStatusCodeValue() == 200) {
                String body = entity.getBody();
                pollutionJson = JSON.parseObject(body);
                valueOperations.set(url, body, 60 * 5, TimeUnit.SECONDS);
            } else {
                log.error("Request error! url:" + url);
                log.error("return value:" + entity);
            }
        }
        JSONArray pollutions = pollutionJson.getJSONArray("data");
        List<Pollution> pollutionList = JSON.parseArray(pollutions.toString(), Pollution.class);

        return pollutionList;
    }

    public List<Pm25> getPm25BySiteAndTime(String site, String startTime, String endTime) {
        String url = "http://airnet.ink/api/forecast/" + site + "?start=" + startTime + "&end=" + endTime;
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        JSONObject pm25Json = null;
        if (stringRedisTemplate.hasKey(url)) {
            pm25Json = JSON.parseObject(valueOperations.get(url));
            // 否则调用API获取
        } else {
            if (entity.getStatusCodeValue() == 200) {
                String body = entity.getBody();
                pm25Json = JSON.parseObject(body);
                valueOperations.set(url, body, 60 * 5, TimeUnit.SECONDS);

            } else {
                log.error("Request error! url:" + url);
                log.error("return value:" + entity);
            }
        }
        JSONArray pm25 = pm25Json.getJSONArray("data");
        List<Pm25> pm25List = JSON.parseArray(pm25.toString(), Pm25.class);
        return pm25List;
    }

}
