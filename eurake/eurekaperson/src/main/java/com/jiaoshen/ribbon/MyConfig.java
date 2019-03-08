package com.jiaoshen.ribbon;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;

public class MyConfig {
	@Bean
	public IRule getRule(){
		return new MyRule();
	}
	@Bean
	public IPing getPing(){
		return new MyPing();
	}

}
