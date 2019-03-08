package com.jiaoshen;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
@SpringBootApplication
@EnableEurekaServer
public class Application {
    public static void main(String[] args) {
    	Scanner scan=new Scanner(System.in);
    	String profiles=scan.nextLine();
		new SpringApplicationBuilder(Application.class).profiles(profiles).run(args);
    	//SpringApplication.run(Application.class, args);
	}

}
