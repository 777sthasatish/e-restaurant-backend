package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.port.driven.PaymentRepoPort;
import com.cotiviti.erestaurantbackend.drivenadapter.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
@RequiredArgsConstructor
@Transactional
public class PaymentAdapter implements PaymentRepoPort {

    private final PaymentRepository paymentRepository;

    @Override
    public void checkout(String id) {
        paymentRepository.findById(tryParseLong(id))
                .ifPresent(value -> {
                    value.setStatus(true);
                    value.setPaymentDate(new Date());
                });
    }

    private Long tryParseLong(String id) {
        try {
            return id == null ? 0 : Long.parseLong(id);
        } catch (NumberFormatException var2) {
            throw new NumberFormatException();
        }
    }
}
