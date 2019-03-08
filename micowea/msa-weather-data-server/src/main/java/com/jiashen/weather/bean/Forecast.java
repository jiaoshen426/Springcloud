package com.jiashen.weather.bean;

import lombok.NoArgsConstructor;

/**
 * @author jiaoshen
 * @date 2019/2/6-${time}
 */
@NoArgsConstructor
@lombok.Data
public  class Forecast {
    /**
     * date : 6日星期三
     * high : 高温 27℃
     * fengli : <![CDATA[<3级]]>
     * low : 低温 20℃
     * fengxiang : 无持续风向
     * type : 多云
     */

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}