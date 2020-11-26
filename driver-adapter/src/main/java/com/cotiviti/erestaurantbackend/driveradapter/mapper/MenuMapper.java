package com.cotiviti.erestaurantbackend.driveradapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.MenuModel;
import com.cotiviti.erestaurantbackend.driveradapter.dto.MenuDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDTO> toDTOS(List<MenuModel> menus);
}

