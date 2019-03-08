package com.jiashen.weather.controller;

import com.jiashen.weather.bean.WeatherResult;
import com.jiashen.weather.service.WeatherDataService;
import com.jiashen.weather.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiaoshen
 * @date 2019/2/4-${time}
 */
@RestController
public class WeatherDataController {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WeatherDataService weatherDataService;

    @GetMapping(value ="/test1")
    String testCon(){
        throw new ServiceException("just test");
    }

    @GetMapping(value ="/getWeaByCityId/{cityId}")
    WeatherResult getWeaByCityId(@PathVariable("cityId")String cityId){
       return weatherDataService.getWeatherById(cityId);
    }

    @GetMapping(value ="/getWeaByCityName/{cityName}")
    WeatherResult getWeaByCityName(@PathVariable("cityName")String cityName){
        return weatherDataService.getWeatherByName(cityName);
    }

}
