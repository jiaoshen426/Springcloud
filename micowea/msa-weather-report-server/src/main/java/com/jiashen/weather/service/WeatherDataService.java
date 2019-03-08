package com.jiashen.weather.service;

import com.jiashen.weather.bean.Weather;


/**
 * 获取天气信息
 *
 * @author jiaoshen
 * @date 2019/2/6-${time}
 */
public interface WeatherDataService {


    /**
     * 获取天气报告数据
     *
     * @param cityId
     * @return
     */
    public Weather getWeatherReportData(String cityId);

}
