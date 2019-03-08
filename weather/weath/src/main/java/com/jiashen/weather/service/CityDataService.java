package com.jiashen.weather.service;

import com.jiashen.weather.bean.City;

import java.util.List;

/**
 * @author jiaoshen
 * @date 2019/2/9-14:21
 */
public interface CityDataService {
    /**
     * 获取城市列表
     * @return
     */
    List<City> listCity() throws Exception;
}
