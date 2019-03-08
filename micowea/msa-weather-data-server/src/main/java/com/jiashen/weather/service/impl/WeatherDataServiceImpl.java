package com.jiashen.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiashen.weather.bean.WeatherResult;
import com.jiashen.weather.service.WeatherDataService;
import com.jiashen.weather.util.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author jiaoshen
 * @date 2019/2/6-${time}
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataServiceImpl.class);


    public static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";

    public static final int REDIS_TIME = 1000;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public WeatherResult getWeatherById(String cityId) {
        String uri = WEATHER_URI + "?citykey=" + cityId;
        return doGetWeahter(uri);
    }

    @Override
    public WeatherResult getWeatherByName(String cityName) {
        String uri = WEATHER_URI + "?City=" + cityName;
        return doGetWeahter(uri);
    }


    /**
     * 根据RUI查找天气信息
     *
     * @param uri
     * @return
     */
    private WeatherResult doGetWeahter(String uri) {
        WeatherResult resp = null;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        //从redis取数据
        if (stringRedisTemplate.hasKey(uri)) {
            LOGGER.info("Redis has data");
            strBody = ops.get(uri);
        } else {
            LOGGER.error("Redis don't has  data");
            throw new ServiceException("Redis don't has  data");
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            resp = mapper.readValue(strBody, WeatherResult.class);
        } catch (IOException e) {
            LOGGER.error("REDIS" + e);
        }
        return resp;
    }
}
