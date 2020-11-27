package com.cotiviti.erestaurantbackend.domain.port.driven;

import com.cotiviti.erestaurantbackend.domain.port.DashboardPort;

public interface DashboardRepoPort extends DashboardPort {
    long countTotalOrders();
    long countPendingPayments();
    long countTodayRevenue();
    String maxSoldFood();
}
