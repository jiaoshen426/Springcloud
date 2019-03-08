package org.crazyit.cloud;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyConfig {

	@Bean
	public IRule getRule() {
		return new MyRule();
	}
}
