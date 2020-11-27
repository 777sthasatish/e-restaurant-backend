package com.cotiviti.erestaurantbackend.driveradapter.dto;

import lombok.Data;

@Data
public class DashboardMetricDTO {
    private long totalOrders;
    private long pendingPayments;
    private long todaysRevenue;
    private String maxSoldFood;
}
