package com.cotiviti.erestaurantbackend.driveradapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.cotiviti.erestaurantbackend.driveradapter")
@PropertySource("classpath:driver.properties")
public class DriverAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverAdapterApplication.class, args);
	}

}
