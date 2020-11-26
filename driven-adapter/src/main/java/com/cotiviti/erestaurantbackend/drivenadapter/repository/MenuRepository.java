package com.cotiviti.erestaurantbackend.drivenadapter.repository;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Optional<List<Menu>> getMenuByEnabledOrderByOrderAsc(boolean enabled);
}
