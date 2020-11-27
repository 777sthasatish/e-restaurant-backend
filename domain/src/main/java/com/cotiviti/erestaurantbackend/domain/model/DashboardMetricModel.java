package com.cotiviti.erestaurantbackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardMetricModel {
    private long totalOrders;
    private long pendingPayments;
    private long todaysRevenue;
    private String maxSoldFood;
}
