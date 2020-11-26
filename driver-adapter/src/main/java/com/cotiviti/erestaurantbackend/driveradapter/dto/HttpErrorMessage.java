package com.cotiviti.erestaurantbackend.driveradapter.dto;

import com.cotiviti.erestaurantbackend.driveradapter.dto.base.MessageResponse;

public class HttpErrorMessage extends MessageResponse {
    public HttpErrorMessage() {
    }

    public HttpErrorMessage(int code, String status, String message) {
        super(code, status, message);
    }
}
