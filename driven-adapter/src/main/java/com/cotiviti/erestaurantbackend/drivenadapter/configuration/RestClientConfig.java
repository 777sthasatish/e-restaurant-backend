package com.cotiviti.erestaurantbackend.drivenadapter.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestClientConfig {
    @Value("${clientUsername}")
    private String clientUsername;

    @Value("${clientPassword}")
    private String clientPassword;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(clientUsername, clientPassword));
        return restTemplate;
    }
}
