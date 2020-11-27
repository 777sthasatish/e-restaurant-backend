package com.cotiviti.erestaurantbackend.driveradapter.controller.secured;

import com.cotiviti.erestaurantbackend.domain.port.driver.FoodOrderUseCase;
import com.cotiviti.erestaurantbackend.driveradapter.dto.FoodOrderDTO;
import com.cotiviti.erestaurantbackend.driveradapter.mapper.FoodOrderMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<FoodOrderDTO>> getAllPending() {
        return ResponseEntity.ok(foodOrderMapper.toDTOs(foodOrderUseCase.getAllPending()));
    }

    @GetMapping(ID_PATH)
    public ResponseEntity<List<FoodOrderDTO>> getAllBy(@PathVariable String id) {
        return ResponseEntity.ok(foodOrderMapper.toDTOs(foodOrderUseCase.getAllPendingBy(id)));
    }
}
