package com.cotiviti.erestaurantbackend.domain.port.driven;

import com.cotiviti.erestaurantbackend.domain.model.AuthenticatorModel;
import com.cotiviti.erestaurantbackend.domain.port.AuthenticationPort;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface AuthenticationRepoPort extends AuthenticationPort {

    URI getURI(AuthenticatorModel authenticatorModel);

    ResponseEntity<String> requestAuthServer( URI uri);
}
