package com.cotiviti.erestaurantbackend.domain.port.driver.service;

import com.cotiviti.erestaurantbackend.domain.model.FoodOrderModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.FoodOrderRepoPort;
import com.cotiviti.erestaurantbackend.domain.port.driver.FoodOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodOrderService implements FoodOrderUseCase {

    private final FoodOrderRepoPort foodOrderRepoPort;

    @Override
    public FoodOrderModel add(FoodOrderModel foodOrderModel) {
        return foodOrderRepoPort.add(foodOrderModel);
    }
}
