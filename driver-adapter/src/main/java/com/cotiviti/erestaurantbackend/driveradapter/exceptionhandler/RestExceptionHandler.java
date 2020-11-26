package com.cotiviti.erestaurantbackend.driveradapter.exceptionhandler;

import com.cotiviti.erestaurantbackend.domain.exception.RestTemplateException;
import com.satish.fieldvalidator.restadapter.exception.RestAdapterExceptionHandler;
import com.satish.fieldvalidator.webcore.dto.DataBindErrorResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@Import(RestAdapterExceptionHandler.class)
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestTemplateException.class)
    public ResponseEntity<DataBindErrorResponse> handleRestTemplateException(RestTemplateException ex) throws IOException {
        DataBindErrorResponse dataBindErrorResponse =  new ObjectMapper().readValue(ex.getMessage(), DataBindErrorResponse.class);
        int statusCode = dataBindErrorResponse.getStatus() == null ? dataBindErrorResponse.getCode() : dataBindErrorResponse.getStatus().value();
        return ResponseEntity.status(statusCode).body(dataBindErrorResponse);
    }
}
