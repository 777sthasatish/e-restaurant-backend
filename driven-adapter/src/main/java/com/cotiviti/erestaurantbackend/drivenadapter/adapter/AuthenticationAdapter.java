package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.exception.RestTemplateException;
import com.cotiviti.erestaurantbackend.domain.model.AuthenticatorModel;
import com.cotiviti.erestaurantbackend.domain.port.AuthenticationPort;
import com.cotiviti.erestaurantbackend.domain.port.driven.AuthenticationRepoPort;
import lombok.RequiredArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@Transactional
@Repository
@RequiredArgsConstructor
public class AuthenticationAdapter implements AuthenticationRepoPort {
    @Value("${tokenEndPoint}")
    private String tokenEndPoint;

    @Value("${grantTypeValue}")
    private String grantTypeValue;

    private final RestTemplate restTemplate;

    @Override
    public OAuth2AccessToken retrieveAccessToken(AuthenticatorModel authenticatorModel) throws IOException {
        try {
            return new ObjectMapper()
                    .readValue(requestAuthServer(getURI(authenticatorModel)).getBody(), OAuth2AccessToken.class);
        } catch (HttpClientErrorException he) {
           throw new RestTemplateException(he.getResponseBodyAsString());
        }

    }

    @Override
    public URI getURI(AuthenticatorModel authenticatorModel) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(tokenEndPoint);
        uriComponentsBuilder
                .queryParam("username", authenticatorModel.getUsername())
                .queryParam("password", authenticatorModel.getPassword())
                .queryParam("grant_type", grantTypeValue);

        return uriComponentsBuilder.buildAndExpand().toUri();
    }

    @Override
    public ResponseEntity<String> requestAuthServer(URI uri) {
        return this.restTemplate.postForEntity(uri, null, String.class);
    }

}
