package org.crazyit.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String port = scan.nextLine();
		new SpringApplicationBuilder(ProviderApp.class).properties("server.port=" + port).run(args);
	}

}
