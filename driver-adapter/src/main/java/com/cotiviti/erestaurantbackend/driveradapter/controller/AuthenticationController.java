package com.cotiviti.erestaurantbackend.driveradapter.controller;

import com.cotiviti.erestaurantbackend.domain.port.driver.AuthenticationUseCase;
import com.cotiviti.erestaurantbackend.driveradapter.dto.AuthenticatorDTO;
import com.cotiviti.erestaurantbackend.driveradapter.mapper.AuthenticatorMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.*;

@RestController
@RequestMapping(BASE_PATH_V1 + PUBLIC + LOGIN)
public class AuthenticationController {

    private final AuthenticationUseCase authenticationUseCase;

    private final AuthenticatorMapper authenticatorMapper = Mappers.getMapper(AuthenticatorMapper.class);

    public AuthenticationController(final AuthenticationUseCase loginUseCase) {
        this.authenticationUseCase = loginUseCase;
    }

    @PostMapping
    public ResponseEntity<OAuth2AccessToken> login(@RequestBody @Valid AuthenticatorDTO authenticatorDTO) throws IOException {
        return ResponseEntity.ok(authenticationUseCase
                .retrieveAccessToken(authenticatorMapper.toModel(authenticatorDTO))
        );
    }
}
