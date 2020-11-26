package com.cotiviti.erestaurantbackend.domain.port.driver.service;

import com.cotiviti.erestaurantbackend.domain.port.driven.PublicFieldRepoPort;
import com.cotiviti.erestaurantbackend.domain.port.driver.PublicFieldUseCase;
import com.satish.fieldvalidator.domain.domain.FieldDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicFieldService implements PublicFieldUseCase {

    private final PublicFieldRepoPort fieldRepoPort;

    public PublicFieldService(final PublicFieldRepoPort fieldRepoPort) {
        this.fieldRepoPort = fieldRepoPort;
    }

    @Override
    public List<FieldDomain> getActiveFields() {
        return fieldRepoPort.getActiveFields();
    }
}
