package com.cotiviti.erestaurantbackend.domain.port.driver.service;

import com.cotiviti.erestaurantbackend.domain.model.MenuModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.MenuRepoPort;
import com.cotiviti.erestaurantbackend.domain.port.driver.MenuUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService implements MenuUseCase {
    private final MenuRepoPort menuRepoPort;

    @Override
    public List<MenuModel> getMenusByEnabled(boolean enabled) {
        return menuRepoPort.getMenusByEnabled(enabled);
    }
}
