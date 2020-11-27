package com.cotiviti.erestaurantbackend.domain.port.driver.service;

import com.cotiviti.erestaurantbackend.domain.model.DashboardMetricModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.DashboardRepoPort;
import com.cotiviti.erestaurantbackend.domain.port.driver.DashboardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService implements DashboardUseCase {

    private final DashboardRepoPort dashboardRepoPort;

    @Override
    public DashboardMetricModel getMetrics() {
        return dashboardRepoPort.getMetrics();
    }
}
