package com.cotiviti.erestaurantbackend.drivenadapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.MenuModel;
import com.cotiviti.erestaurantbackend.drivenadapter.entity.Menu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuModel> toModels(List<Menu> menus);
}

