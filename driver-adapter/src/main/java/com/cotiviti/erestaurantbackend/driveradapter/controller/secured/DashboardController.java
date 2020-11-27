package com.cotiviti.erestaurantbackend.driveradapter.controller.secured;

import com.cotiviti.erestaurantbackend.domain.port.driver.DashboardUseCase;
import com.cotiviti.erestaurantbackend.driveradapter.dto.DashboardMetricDTO;
import com.cotiviti.erestaurantbackend.driveradapter.mapper.DashboardMetricMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.*;

@RestController
@RequestMapping(BASE_PATH_V1 + DASHBOARD)
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardUseCase dashboardUseCase;
    private final DashboardMetricMapper dashboardMetricMapper = Mappers.getMapper(DashboardMetricMapper.class);

    @GetMapping
    public ResponseEntity<DashboardMetricDTO> getMetrics() {
        return ResponseEntity.ok(dashboardMetricMapper.toDTO(dashboardUseCase.getMetrics()));
    }
}
