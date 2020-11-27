package com.cotiviti.erestaurantbackend.domain.port;

import com.cotiviti.erestaurantbackend.domain.model.DashboardMetricModel;

public interface DashboardPort {
    DashboardMetricModel getMetrics();
}
