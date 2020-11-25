package com.cotiviti.erestaurantbackend.driveradapter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "restaurant-backend";
    @Bean
    public TokenStore tokenStore() {
        return  new JwtTokenStore(accessTokenConverter());
    }

    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setVerifierKey("1234");
        return jwtAccessTokenConverter;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        OAuth2AuthenticationManager oAuth2AuthenticationManager = new OAuth2AuthenticationManager();
        oAuth2AuthenticationManager.setTokenServices(new DefaultTokenServices());
        return oAuth2AuthenticationManager;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID).authenticationManager(authenticationManager());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .httpBasic().disable()
                .anonymous()
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/public/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling();
    }
}
