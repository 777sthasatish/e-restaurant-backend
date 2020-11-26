package com.cotiviti.erestaurantbackend.drivenadapter.repository;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
