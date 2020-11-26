package com.cotiviti.erestaurantbackend.driveradapter.controller.secured;

import com.cotiviti.erestaurantbackend.domain.port.driver.MenuUseCase;
import com.cotiviti.erestaurantbackend.driveradapter.dto.MenuDTO;
import com.cotiviti.erestaurantbackend.driveradapter.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.*;

@RestController
@RequestMapping(BASE_PATH_V1 + MENU)
@RequiredArgsConstructor
public class MenuController {

    private final MenuUseCase menuUseCase;

    private final MenuMapper menuMapper = Mappers.getMapper(MenuMapper.class);

    @GetMapping
    public ResponseEntity<List<MenuDTO>> getMenusByEnabled(@RequestParam boolean enabled) {
        List<MenuDTO> menuDTOS = menuMapper.toDTOS(menuUseCase.getMenusByEnabled(enabled));
        return ResponseEntity.ok(menuDTOS);
    }
}
