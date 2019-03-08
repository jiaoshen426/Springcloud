package com.jiashen.weather.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jiaoshen
 * @date 2019/2/10-11:14
 */
@Data
@AllArgsConstructor
public class Bresult {
    private String code;
    private String msg;
    private Object data;

    public Bresult(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Bresult(String code, Object data) {
        this.code = code;
        this.data = data;
    }
}
