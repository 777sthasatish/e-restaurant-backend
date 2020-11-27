package com.cotiviti.erestaurantbackend.drivenadapter.repository;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Billing, Long> {
}
