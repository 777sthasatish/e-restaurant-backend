package com.cotiviti.erestaurantbackend.domain.model;

import com.cotiviti.erestaurantbackend.domain.model.base.Identity;
import lombok.Data;

import java.util.List;

@Data
public class FoodCategoryModel extends Identity<Long> {
    private String name;
    private List<FoodMenuModel> menus;
}
