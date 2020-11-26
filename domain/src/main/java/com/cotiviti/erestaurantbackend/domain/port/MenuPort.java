package com.cotiviti.erestaurantbackend.domain.port;

import com.cotiviti.erestaurantbackend.domain.model.MenuModel;

import java.util.List;

public interface MenuPort {
    List<MenuModel> getMenusByEnabled(boolean enabled);
}
