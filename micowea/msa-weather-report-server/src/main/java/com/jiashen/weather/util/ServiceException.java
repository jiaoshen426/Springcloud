package com.jiashen.weather.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jiaoshen
 * @date 2019/2/10-9:43
 */
@Getter
@Setter
public class ServiceException extends  RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errCode;
    private String errMsg;
    public ServiceException(String errMsg){
        this.errCode = "500";
        this.errMsg =errMsg;
    }
    public ServiceException(String errCode,String errMsg){
       this.errCode = errCode;
        this.errMsg =errMsg;
    }

}
