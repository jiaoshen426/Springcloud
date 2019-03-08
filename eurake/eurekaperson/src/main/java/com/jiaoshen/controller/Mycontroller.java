package com.jiaoshen.controller;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jiaoshen.bean.Person;

@RestController
@Configuration
public class Mycontroller {
//    @Autowired
//    private ApplicationContext ctx;
     
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
    	return new RestTemplate();
    }
    
	@RequestMapping(value="/router")
	public String getName(){
		RestTemplate template=getRestTemplate();
		String json=template.getForObject("http://first-police/person/1002324", String .class);
		return json;
	}
}
