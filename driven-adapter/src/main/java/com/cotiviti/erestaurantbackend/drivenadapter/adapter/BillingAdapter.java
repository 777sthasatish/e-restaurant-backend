package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.model.BillingModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.BillingRepoPort;
import com.cotiviti.erestaurantbackend.drivenadapter.mapper.BillingMapper;
import com.cotiviti.erestaurantbackend.drivenadapter.repository.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BillingAdapter implements BillingRepoPort {

    private final BillingRepository billingRepository;
    private final BillingMapper billingMapper = Mappers.getMapper(BillingMapper.class);

    @Override
    public BillingModel save(BillingModel billingModel) {
        return billingMapper.toModel(billingRepository.save(billingMapper.toEntity(billingModel)));
    }
}
