package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ZcloudConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZcloudConfigServiceApplication.class, args);
	}

}
