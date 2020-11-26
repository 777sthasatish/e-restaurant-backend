package com.cotiviti.erestaurantbackend.driveradapter.controller.open;

import com.cotiviti.erestaurantbackend.domain.port.driver.PublicFieldUseCase;
import com.satish.common.mapper.generics.CollectionMapper;
import com.satish.common.mapper.generics.concrete.CollectionMapperFactory;
import com.satish.common.util.CollectionKey;
import com.satish.fieldvalidator.domain.domain.FieldDomain;
import com.satish.fieldvalidator.webcore.dto.FieldDTO;
import com.satish.fieldvalidator.webcore.mapper.FieldMapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.*;

@RestController
@RequestMapping(BASE_PATH_V1 + PUBLIC + FIELD)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PublicFieldController {

    private final PublicFieldUseCase publicFieldService;
    private final CollectionMapper<FieldDTO, FieldDomain> fieldsMapper;

    public PublicFieldController(final FieldMapper fieldMapper, final PublicFieldUseCase publicFieldService) {
        this.fieldsMapper =  CollectionMapperFactory.getMapper(CollectionKey.LIST, fieldMapper);
        this.publicFieldService = publicFieldService;
    }

    @GetMapping
    public ResponseEntity<List<FieldDTO>> getActiveFields() {
        return ResponseEntity.ok ((List<FieldDTO>)fieldsMapper.toTargets(publicFieldService.getActiveFields()));
    }
}
