package com.cotiviti.erestaurantbackend.domain.port.driver.service;

import com.cotiviti.erestaurantbackend.domain.model.FoodCategoryModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.FoodCategoryRepoPort;
import com.cotiviti.erestaurantbackend.domain.port.driver.FoodCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService implements FoodCategoryUseCase {

    private final FoodCategoryRepoPort foodCategoryRepo;

    @Override
    public List<FoodCategoryModel> getAll() {
        return foodCategoryRepo.getAll();
    }
}
