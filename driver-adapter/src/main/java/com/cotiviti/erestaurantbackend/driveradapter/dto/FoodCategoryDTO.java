package com.cotiviti.erestaurantbackend.driveradapter.dto;

import com.cotiviti.erestaurantbackend.driveradapter.dto.base.Identity;
import lombok.Data;

import java.util.List;

@Data
public class FoodCategoryDTO extends Identity<Long> {
    private String name;
    private List<FoodMenuDTO> menus;
}
