package com.cotiviti.erestaurantbackend.driveradapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.FoodCategoryModel;
import com.cotiviti.erestaurantbackend.driveradapter.dto.FoodCategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FoodCategoryMapper {
    List<FoodCategoryDTO> toDTOS(List<FoodCategoryModel> foodCategories);
}
