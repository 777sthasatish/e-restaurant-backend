package com.cotiviti.erestaurantbackend.domain.port;

import com.cotiviti.erestaurantbackend.domain.model.FoodOrderModel;

public interface FoodOrderPort {
    FoodOrderModel add(FoodOrderModel foodOrderModel);
}
