package com.jiashen.weather.service;

/**
 * @author jiaoshen
 * @date 2019/2/9-14:21
 */
public interface WeatherDataCollectionService {
    /**
     * 根据城市ID同步天气数据
     *
     * @param cityId
     */
    public void syncWeather(String cityId);
}
