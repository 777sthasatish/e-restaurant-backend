package com.cotiviti.erestaurantbackend.driveradapter.dto;

import com.cotiviti.erestaurantbackend.driveradapter.dto.base.Identity;
import lombok.Data;

import java.util.Date;

@Data
public class FoodOrderDTO extends Identity<Long> {
    private BillingDTO billing;

    private FoodMenuDTO foodMenu;

    private int quantity;

    private TableDTO table;

    private Date orderDate;
}