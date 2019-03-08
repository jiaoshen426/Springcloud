package com.jiaoshen;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
@SpringBootApplication
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

}
