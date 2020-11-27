package com.cotiviti.erestaurantbackend.driveradapter.controller.secured;

import com.satish.fieldvalidator.domain.api.FieldServicePort;
import com.satish.fieldvalidator.webcore.dto.FieldDTO;
import com.satish.fieldvalidator.webcore.mapper.FieldMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.*;

@RestController
@RequestMapping(BASE_PATH_V1 + FIELD)
@RequiredArgsConstructor
public class CustomFieldController {
    private final FieldServicePort fieldServicePort;
    private final FieldMapper fieldMapper;

    @GetMapping
    public ResponseEntity<List<FieldDTO>> getActiveFields() {
        return ResponseEntity.ok(fieldMapper.toTargetList(fieldServicePort.getActiveFields()));
    }
}
