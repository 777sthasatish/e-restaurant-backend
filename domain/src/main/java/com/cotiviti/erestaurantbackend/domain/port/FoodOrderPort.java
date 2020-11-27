package com.cotiviti.erestaurantbackend.domain.port;

import com.cotiviti.erestaurantbackend.domain.model.FoodOrderModel;

import java.util.List;

public interface FoodOrderPort {
    FoodOrderModel add(FoodOrderModel foodOrderModel);
    List<FoodOrderModel> getAllPending();
    List<FoodOrderModel> getAllPendingBy(String id);
}
