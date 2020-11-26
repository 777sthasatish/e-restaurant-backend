package com.cotiviti.erestaurantbackend.driveradapter.controller.secured;

import com.cotiviti.erestaurantbackend.domain.port.driver.TableUseCase;
import com.cotiviti.erestaurantbackend.driveradapter.dto.TableDTO;
import com.cotiviti.erestaurantbackend.driveradapter.mapper.TableMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.BASE_PATH_V1;
import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.TABLE;

@RestController
@RequestMapping(BASE_PATH_V1 + TABLE)
@RequiredArgsConstructor
public class TableController {

    private final TableUseCase tableUseCase;
    private final TableMapper tableMapper = Mappers.getMapper(TableMapper.class);

    @GetMapping
    public ResponseEntity<List<TableDTO>> getAll() {
        return ResponseEntity.ok(tableMapper.toDTOs(tableUseCase.getAll()));
    }
}
