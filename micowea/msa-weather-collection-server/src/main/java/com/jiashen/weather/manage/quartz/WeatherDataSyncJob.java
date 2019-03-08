package com.jiashen.weather.manage.quartz;

import com.jiashen.weather.bean.City;
import com.jiashen.weather.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaoshen
 * @date 2019/2/8-14:59
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    WeatherDataCollectionService weatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {

        log.info("Weather data quartz start");
        List<City> cityList = null;

        cityList = new ArrayList<>();
        City cityTest = new City();
        cityTest.setCityId("101280601");
        cityList.add(cityTest);
        for (City city : cityList) {
            weatherDataCollectionService.syncWeather(city.getCityId());
        }
        log.info("Weather data quartz end！ num：" + cityList.size());


    }
}

