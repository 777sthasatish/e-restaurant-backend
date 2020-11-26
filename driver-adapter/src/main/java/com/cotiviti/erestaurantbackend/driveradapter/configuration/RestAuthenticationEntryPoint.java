package com.cotiviti.erestaurantbackend.driveradapter.configuration;


import com.cotiviti.erestaurantbackend.driveradapter.dto.HttpErrorMessage;
import com.cotiviti.erestaurantbackend.driveradapter.dto.base.MessageResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        if (authException instanceof InsufficientAuthenticationException) {
            InsufficientAuthenticationException authenticationException = (InsufficientAuthenticationException) authException;
            MessageResponse messageResponse = new HttpErrorMessage(401, "unauthorized", authenticationException.getMessage());
            checkOAuth2Exception(authenticationException, messageResponse);
            OutputStream outputStream = response.getOutputStream();
            response.setStatus(messageResponse.getCode());
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(outputStream, messageResponse);
            outputStream.flush();
        }
    }

    private void checkOAuth2Exception(InsufficientAuthenticationException authenticationException, MessageResponse messageResponse) {
        Throwable cause = authenticationException.getCause();
        if (cause instanceof OAuth2Exception) {
            OAuth2Exception exception = (OAuth2Exception) cause;
            messageResponse.setCode(exception.getHttpErrorCode());
            messageResponse.setStatus(exception.getOAuth2ErrorCode());
            messageResponse.setMessage(exception.getMessage());
        }
    }
}
