package com.cotiviti.erestaurantbackend.domain.port.driver.service;

import com.cotiviti.erestaurantbackend.domain.port.driven.PaymentRepoPort;
import com.cotiviti.erestaurantbackend.domain.port.driver.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentUseCase {
    private final PaymentRepoPort repoPort;

    @Override
    public void checkout(String id) {
        repoPort.checkout(id);
    }
}
