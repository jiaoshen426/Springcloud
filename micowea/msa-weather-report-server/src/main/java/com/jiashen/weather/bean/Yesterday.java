package com.jiashen.weather.bean;

import lombok.NoArgsConstructor;

/**
 * @author jiaoshen
 * @date 2019/2/6-${time}
 */
@NoArgsConstructor
@lombok.Data
public  class Yesterday {
    /**
     * date : 5日星期二
     * high : 高温 25℃
     * fx : 无持续风向
     * low : 低温 18℃
     * fl : <![CDATA[<3级]]>
     * type : 多云
     */

    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}