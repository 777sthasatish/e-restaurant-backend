package com.cotiviti.erestaurantbackend.drivenadapter.repository;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
