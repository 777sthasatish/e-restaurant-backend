package com.cotiviti.erestaurantbackend.driveradapter.controller.secured;

import com.cotiviti.erestaurantbackend.domain.port.driver.FoodCategoryUseCase;
import com.cotiviti.erestaurantbackend.driveradapter.dto.FoodCategoryDTO;
import com.cotiviti.erestaurantbackend.driveradapter.mapper.FoodCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.*;

@RestController
@RequestMapping(BASE_PATH_V1 + FOOD_MENU)
@RequiredArgsConstructor
public class FoodMenuCategoryController {

    private final FoodCategoryUseCase foodCategoryUseCase;
    private final FoodCategoryMapper foodCategoryMapper = Mappers.getMapper(FoodCategoryMapper.class);

    @GetMapping
    public ResponseEntity<List<FoodCategoryDTO>> getFoodCategories() {
        return ResponseEntity.ok(foodCategoryMapper.toDTOS(foodCategoryUseCase.getAll()));
    }
}
