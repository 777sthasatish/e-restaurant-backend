package com.cotiviti.erestaurantbackend.drivenadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:driven.properties")
public class DrivenAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrivenAdapterApplication.class, args);
	}

}
