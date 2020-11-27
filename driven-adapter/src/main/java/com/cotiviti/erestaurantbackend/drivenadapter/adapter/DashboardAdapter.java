package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.model.DashboardMetricModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.DashboardRepoPort;
import com.cotiviti.erestaurantbackend.drivenadapter.repository.FoodOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
@RequiredArgsConstructor
@Transactional
public class DashboardAdapter implements DashboardRepoPort {

    private final FoodOrderRepository foodOrderRepository;

    @Override
    public DashboardMetricModel getMetrics() {
        long totalOrders = countTotalOrders();
        long pendingPayments = countPendingPayments();
        long todaysRevenue = countTodayRevenue();
        String maxSoldFood = maxSoldFood();
        return new DashboardMetricModel(totalOrders, pendingPayments, todaysRevenue, maxSoldFood);
    }

    @Override
    public long countTotalOrders() {
        return foodOrderRepository.countByOrderDate(new Date());
    }

    @Override
    public long countPendingPayments() {
        return foodOrderRepository.countPendingPayments();
    }

    @Override
    public long countTodayRevenue() {
        return foodOrderRepository.todaysRevenue();
    }

    @Override
    public String maxSoldFood() {
        return foodOrderRepository.mostOrderItem().getFoodMenu().getName();
    }
}
