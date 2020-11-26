package com.cotiviti.erestaurantbackend.driveradapter;

import com.satish.fieldvalidator.mvcadapter.annotation.EnableUI;
import com.satish.fieldvalidator.restadapter.annotation.EnableFieldValidatorRest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.cotiviti.erestaurantbackend.driveradapter")
@EnableFieldValidatorRest
@EnableUI
@PropertySource("classpath:driver.properties")
public class DriverAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverAdapterApplication.class, args);
	}

}
