package com.marticles.microservice.airpollution.history.service.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.marticles.microservice.airpollution.history.service.model.Pollution;
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
 * @description HistoryService
 * @date 2019/1/14
 */
@Slf4j
@Service
public class HistoryService {

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


}
