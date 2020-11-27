package com.cotiviti.erestaurantbackend.driveradapter.controller.secured;

import com.cotiviti.erestaurantbackend.domain.port.driver.FoodOrderUseCase;
import com.cotiviti.erestaurantbackend.driveradapter.dto.FoodOrderDTO;
import com.cotiviti.erestaurantbackend.driveradapter.mapper.FoodOrderMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.*;

@RestController
@RequestMapping(BASE_PATH_V1 + ORDER)
@RequiredArgsConstructor
public class FoodOrderController {

    private final FoodOrderUseCase foodOrderUseCase;
    private final FoodOrderMapper foodOrderMapper = Mappers.getMapper(FoodOrderMapper.class);

    @PostMapping
    public ResponseEntity<FoodOrderDTO> addOrder(@RequestBody FoodOrderDTO foodOrderDTO) {
        return ResponseEntity.ok(
              this.foodOrderMapper.toDTO(this.foodOrderUseCase.add(this.foodOrderMapper.toModel(foodOrderDTO)))
        );
    }
}
