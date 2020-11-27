package com.cotiviti.erestaurantbackend.drivenadapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.FoodOrderModel;
import com.cotiviti.erestaurantbackend.drivenadapter.entity.FoodOrder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FoodOrderMapper {
    List<FoodOrder> toEntites(List<FoodOrderModel> foodOrders);
    FoodOrder toEntity(FoodOrderModel foodOrderModel);

    List<FoodOrderModel> toModels(List<FoodOrder> foodOrders);
    FoodOrderModel toModel(FoodOrder foodOrder);
}
