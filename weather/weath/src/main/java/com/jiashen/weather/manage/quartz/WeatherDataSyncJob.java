package com.jiashen.weather.manage.quartz;

import com.jiashen.weather.bean.City;
import com.jiashen.weather.service.CityDataService;
import com.jiashen.weather.service.WeatherDataService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author jiaoshen
 * @date 2019/2/8-14:59
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean{
    @Autowired
    CityDataService cityDataService;
    @Autowired
    WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            log.info("Weather data quartz start");
            List<City> cityList =cityDataService.listCity();
            for (City city : cityList) {
                weatherDataService.syncWeather(city.getCityId());
            }
            log.info("Weather data quartz end！ num："+cityList.size());
        } catch (Exception e) {
           log.error(e.getMessage());
        }


    }
}

