package com.jiashen.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaoshen
 * @date 2019/2/4-${time}
 */
@RestController
public class HelloController {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);


    @GetMapping(value = "/testHello")
    String testCon() {
        return "weather-collection has started!";
    }


}
