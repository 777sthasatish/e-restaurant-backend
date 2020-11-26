package com.cotiviti.erestaurantbackend.domain.port;

import com.cotiviti.erestaurantbackend.domain.model.FoodCategoryModel;

import java.util.List;

public interface FoodCategoryPort {
    List<FoodCategoryModel> getAll();
}
