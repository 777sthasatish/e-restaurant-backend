package com.cotiviti.erestaurantbackend.drivenadapter;

import com.satish.fieldvalidator.datajpaadapter.annotation.EnableFieldValidatorData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cotiviti.erestaurantbackend.drivenadapter")
@EntityScan(basePackages = "com.cotiviti.erestaurantbackend.drivenadapter.entity")
@EnableJpaRepositories(basePackages = "com.cotiviti.erestaurantbackend.drivenadapter.repository")
@PropertySource("classpath:driven.properties")
@EnableFieldValidatorData
public class DrivenAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrivenAdapterApplication.class, args);
	}

}
