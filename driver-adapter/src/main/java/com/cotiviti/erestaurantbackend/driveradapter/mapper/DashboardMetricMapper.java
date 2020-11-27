package com.cotiviti.erestaurantbackend.driveradapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.DashboardMetricModel;
import com.cotiviti.erestaurantbackend.driveradapter.dto.DashboardMetricDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DashboardMetricMapper {
    DashboardMetricDTO toDTO(DashboardMetricModel dashboardMetricModel);
}
