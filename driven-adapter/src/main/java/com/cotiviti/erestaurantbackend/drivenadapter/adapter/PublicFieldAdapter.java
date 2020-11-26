package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.port.driven.PublicFieldRepoPort;
import com.cotiviti.erestaurantbackend.drivenadapter.util.APIConstant;
import com.satish.fieldvalidator.domain.domain.FieldDomain;
import com.satish.fieldvalidator.webcore.dto.FieldDTO;
import com.satish.fieldvalidator.webcore.mapper.FieldMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class PublicFieldAdapter implements PublicFieldRepoPort {
    @Value("${authURL}")
    private String authURL;

    private final FieldMapper fieldMapper;
    private final RestTemplate restTemplate;

    public PublicFieldAdapter(final FieldMapper fieldMapper, final RestTemplate restTemplate) {
        this.fieldMapper = fieldMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<FieldDomain> getActiveFields() {
        final String fieldURL = authURL + APIConstant.FIELDS_URL;
        FieldDTO[] fieldDTOS = restTemplate.getForObject(fieldURL, FieldDTO[].class);
        List<FieldDTO> fields = fieldDTOS == null ? Collections.emptyList() : Arrays.asList(fieldDTOS);
        return fieldMapper.toSourceList(fields);
    }
}
