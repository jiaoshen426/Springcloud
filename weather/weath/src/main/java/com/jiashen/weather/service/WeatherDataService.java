package com.jiashen.weather.service;

import com.jiashen.weather.bean.Weather;
import com.jiashen.weather.bean.WeatherResult;


/**
 * 获取天气信息
 *
 * @author jiaoshen
 * @date 2019/2/6-${time}
 */
public interface WeatherDataService {


    /**
     * 根据城市ID获取天气数据
     *
     * @param cityId
     * @return
     */
    public WeatherResult getWeatherById(String cityId);


    /**
     * 根据城市名字获取天气数据
     *
     * @param cityName
     * @return
     */
    public WeatherResult getWeatherByName(String cityName);

    /**
     * 根据城市ID同步天气数据
     *
     */
    public void syncWeather(String cityId);

    /**
     * 获取天气报告数据
     *
     * @param cityId
     * @return
     */
    public Weather getWeatherReportData(String cityId);

}
