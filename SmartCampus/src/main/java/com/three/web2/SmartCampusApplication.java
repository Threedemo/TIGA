package com.three.web2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.three.web2.store.StorageProperties;
import com.three.web2.store.StorageService;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SmartCampusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartCampusApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
