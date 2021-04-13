package com.qa.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoServeApplication.class, args);
	}

}
