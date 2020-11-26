package com.cotiviti.erestaurantbackend.domain.port;

import com.satish.fieldvalidator.domain.domain.FieldDomain;

import java.util.List;

public interface PublicFieldPort {
    List<FieldDomain> getActiveFields();
}
