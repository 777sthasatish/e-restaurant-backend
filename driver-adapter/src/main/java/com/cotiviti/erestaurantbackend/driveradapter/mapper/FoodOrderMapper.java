package com.cotiviti.erestaurantbackend.driveradapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.FoodOrderModel;
import com.cotiviti.erestaurantbackend.driveradapter.dto.FoodOrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FoodOrderMapper {
    List<FoodOrderDTO> toDTOs(List<FoodOrderModel> foodOrders);
    FoodOrderDTO toDTO(FoodOrderModel foodOrderModel);

    List<FoodOrderModel> toModels(List<FoodOrderDTO> foodOrderDTOs);
    FoodOrderModel toModel(FoodOrderDTO foodOrderDTO);
}
