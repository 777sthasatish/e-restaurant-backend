package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.model.MenuModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.MenuRepoPort;
import com.cotiviti.erestaurantbackend.drivenadapter.mapper.MenuMapper;
import com.cotiviti.erestaurantbackend.drivenadapter.repository.MenuRepository;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository
@RequiredArgsConstructor
public class MenuAdapter implements MenuRepoPort {

    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper = Mappers.getMapper(MenuMapper.class);

    @Override
    public List<MenuModel> getMenusByEnabled(boolean enabled) {
        return menuMapper.toModels(
                new ArrayList<>(this.menuRepository
                .getMenuByEnabledOrderByOrderAsc(enabled)
                .orElse(Collections.emptyList())));
    }
}
