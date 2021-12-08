package com.silver.ws.uamservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UamServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UamServiceApplication.class, args);
	}

}
