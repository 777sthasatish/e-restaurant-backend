package com.cotiviti.erestaurantbackend.domain.port;

import com.cotiviti.erestaurantbackend.domain.model.AuthenticatorModel;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.io.IOException;

public interface AuthenticationPort {
    OAuth2AccessToken retrieveAccessToken(AuthenticatorModel authenticatorModel) throws IOException;
}
