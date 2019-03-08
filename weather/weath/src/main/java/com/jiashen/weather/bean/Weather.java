package com.jiashen.weather.bean;

import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jiaoshen
 * @date 2019/2/6-${time}
 */
@NoArgsConstructor
@lombok.Data
public class Weather {

    /**
     * yesterday : {"date":"5日星期二","high":"高温 25℃","fx":"无持续风向","low":"低温 18℃","fl":"<![CDATA[<3级]]>","type":"多云"}
     * City : 深圳
     * forecast : [{"date":"6日星期三","high":"高温 27℃","fengli":"<![CDATA[<3级]]>","low":"低温 20℃","fengxiang":"无持续风向","type":"多云"},{"date":"7日星期四","high":"高温 27℃","fengli":"<![CDATA[<3级]]>","low":"低温 19℃","fengxiang":"无持续风向","type":"多云"},{"date":"8日星期五","high":"高温 26℃","fengli":"<![CDATA[<3级]]>","low":"低温 18℃","fengxiang":"无持续风向","type":"多云"},{"date":"9日星期六","high":"高温 24℃","fengli":"<![CDATA[<3级]]>","low":"低温 17℃","fengxiang":"无持续风向","type":"多云"},{"date":"10日星期天","high":"高温 23℃","fengli":"<![CDATA[3-4级]]>","low":"低温 16℃","fengxiang":"东北风","type":"小雨"}]
     * ganmao : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
     * wendu : 25
     */

    private Yesterday yesterday;
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private List<Forecast> forecast;



}
