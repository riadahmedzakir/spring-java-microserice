package com.silver.ws.albumservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlbumSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumSerivceApplication.class, args);
	}

}
