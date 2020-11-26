package com.cotiviti.erestaurantbackend.driveradapter.dto;

import com.cotiviti.erestaurantbackend.driveradapter.dto.base.Identity;
import lombok.Data;

@Data
public class FoodMenuDTO extends Identity<Long> {
    private String name;
    private String prepTime;
    private double price;
    private boolean status;
}
