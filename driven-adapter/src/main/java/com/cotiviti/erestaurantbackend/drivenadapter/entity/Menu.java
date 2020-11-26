package com.cotiviti.erestaurantbackend.drivenadapter.entity;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.base.Identity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_menu")
@Data
public class Menu extends Identity<Integer> {

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String path;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false, unique = true)
    private int order;

    @Column
    private String icon;
}
