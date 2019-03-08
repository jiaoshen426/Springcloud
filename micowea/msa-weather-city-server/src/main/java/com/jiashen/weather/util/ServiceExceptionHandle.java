package com.jiashen.weather.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiaoshen
 * @date 2019/2/10-11:27
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ServiceExceptionHandle {

    @ExceptionHandler(ServiceException.class)
    public Bresult handleServiceException(ServiceException e){
          log.error(e.getErrCode()+":"+e.getErrMsg());
          return new Bresult(e.getErrCode(),e.getErrMsg());


    }

}
