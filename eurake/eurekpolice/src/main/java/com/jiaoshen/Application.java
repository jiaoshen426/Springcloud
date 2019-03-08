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
    	Scanner scan=new Scanner(System.in);
    	String port=scan.nextLine();
		new SpringApplicationBuilder(Application.class).properties("server.port="+port).run(args);
	}

}
