package com.cotiviti.erestaurantbackend.drivenadapter.entity;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.base.Identity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="tbl_food_menu")
@Data
public class FoodMenu extends Identity<Long> {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 10)
    private String prepTime;

    @Column
    private double price;

    @Column
    private boolean status;
}
