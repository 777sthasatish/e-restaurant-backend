package com.cotiviti.erestaurantbackend.drivenadapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.FoodCategoryModel;
import com.cotiviti.erestaurantbackend.drivenadapter.entity.FoodCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FoodCategoryMapper {
    List<FoodCategoryModel> toModels(List<FoodCategory> foodCategories);
}
