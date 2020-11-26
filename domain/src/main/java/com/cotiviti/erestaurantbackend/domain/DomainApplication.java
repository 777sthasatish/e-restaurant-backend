package com.cotiviti.erestaurantbackend.domain;

import com.satish.fieldvalidator.domain.annotation.EnableFieldValidatorDom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@EnableFieldValidatorDom
@SpringBootApplication
@PropertySource("classpath:domain.properties")
public class DomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);
	}

}
