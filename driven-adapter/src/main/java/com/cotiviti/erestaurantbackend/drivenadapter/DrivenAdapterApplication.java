package com.cotiviti.erestaurantbackend.drivenadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.cotiviti.erestaurantbackend.drivenadapter")
@EntityScan(basePackages = "com.cotiviti.erestaurantbackend.drivenadapter.entity")
@PropertySource("classpath:driven.properties")
public class DrivenAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrivenAdapterApplication.class, args);
	}

}
