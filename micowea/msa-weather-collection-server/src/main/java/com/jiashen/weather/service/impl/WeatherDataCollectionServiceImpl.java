package com.jiashen.weather.service.impl;

import com.jiashen.weather.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author jiaoshen
 * @date 2019/2/15-20:28
 */
@Service
@Slf4j
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService  {

    public static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";

    public static final int REDIS_TIME = 1000;
    public static final int HTTP_CODE_200 = 200;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;




    @Override
    public void syncWeather(String cityId) {
        String uri = WEATHER_URI + "?citykey=" + cityId;
        saveWeather(uri);

    }

    /**
     * 缓存天气数据
     * @param uri
     */
    private void saveWeather(String uri) {
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if (respString.getStatusCodeValue() == HTTP_CODE_200) {
            strBody = respString.getBody();
            ops.set(uri, strBody, REDIS_TIME, TimeUnit.SECONDS);
        }
    }




}
