package com.cotiviti.erestaurantbackend.domain.port.driver.service;

import com.cotiviti.erestaurantbackend.domain.model.AuthenticatorModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.AuthenticationRepoPort;
import com.cotiviti.erestaurantbackend.domain.port.driver.AuthenticationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationUseCase {

    private final AuthenticationRepoPort authenticationRepoPort;


    @Override
    public OAuth2AccessToken retrieveAccessToken(AuthenticatorModel authenticatorModel) throws IOException {
        return authenticationRepoPort.retrieveAccessToken(authenticatorModel);
    }
}
