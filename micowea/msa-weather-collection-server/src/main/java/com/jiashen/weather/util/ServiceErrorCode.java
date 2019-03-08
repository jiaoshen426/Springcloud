package com.jiashen.weather.util;

/**
 * @author jiaoshen
 * @date 2019/2/10-9:45
 */
public enum ServiceErrorCode {
    /**
     * 对象为空
     */
    NULL_OBJ("LUO001","对象为空");
    private String value;
    private String desc;

    private ServiceErrorCode(String value, String desc) {
       this.value = value;
       this.desc = desc;
    }

    public String getValue() {
        return value;
    }



    public String getDesc() {
        return desc;
    }



    @Override
    public String toString() {
        return "[" + this.value + "]" + this.desc;
    }


}
