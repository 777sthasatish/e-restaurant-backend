package com.cotiviti.erestaurantbackend.drivenadapter.entity;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.base.Identity;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tbl_food_category")
@Data
public class FoodCategory extends Identity<Long> {

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "food_menu_id", nullable = false)
    private List<FoodMenu> menus;
}
