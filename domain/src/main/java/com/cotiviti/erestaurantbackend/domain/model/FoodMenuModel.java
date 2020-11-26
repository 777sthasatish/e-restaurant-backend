package com.cotiviti.erestaurantbackend.domain.model;

import com.cotiviti.erestaurantbackend.domain.model.base.Identity;
import lombok.Data;

@Data
public class FoodMenuModel extends Identity<Long> {
    private String name;
    private String prepTime;
    private double price;
    private boolean status;
}
