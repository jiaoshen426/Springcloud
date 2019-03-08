package com.jiashen.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiashen.weather.bean.City;
import com.jiashen.weather.bean.Weather;
import com.jiashen.weather.bean.WeatherResult;
import com.jiashen.weather.service.CityDataService;
import com.jiashen.weather.service.WeatherDataService;
import com.jiashen.weather.util.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


    public static final String weatherUri = "http://wthrcdn.etouch.cn/weather_mini";

    public static final int REDIS_TIME = 1000;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    CityDataService cityDataService;

    @Override
    public WeatherResult getWeatherById(String cityId) {
        String uri = weatherUri + "?citykey=" + cityId;
        return doGetWeahter(uri);
    }

    @Override
    public WeatherResult getWeatherByName(String cityName) {
        String uri = weatherUri + "?City=" + cityName;
        return doGetWeahter(uri);
    }

    @Override
    public void syncWeather(String cityId) {
        String uri = weatherUri + "?citykey=" + cityId;
        saveWeather(uri);

    }

    @Override
    public Weather getWeatherReportData(String cityId) {
        return getWeatherById(cityId).getData();
    }

    /**
     * 缓存天气数据
     * @param uri
     */
    private void saveWeather(String uri) {
        WeatherResult resp = null;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
            ops.set(uri, strBody, REDIS_TIME, TimeUnit.SECONDS);
        }
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

        //先从redis取数据 没有再调天气接口取
        if (stringRedisTemplate.hasKey(uri)) {
            LOGGER.info("Redis has data");
            strBody = ops.get(uri);
        } else {
            LOGGER.info("Redis don't has  data");
            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
            if (respString.getStatusCodeValue() == 200) {
                strBody = respString.getBody();
                ops.set(uri, strBody, REDIS_TIME, TimeUnit.SECONDS);
            }else {
                throw new ServiceException("接口返回不是200");
            }
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
