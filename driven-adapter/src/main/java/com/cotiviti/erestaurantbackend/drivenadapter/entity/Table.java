package com.cotiviti.erestaurantbackend.drivenadapter.entity;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.base.Identity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@javax.persistence.Table(name = "tbl_table")
@Data
public class Table extends Identity<Long> {
    @Column(nullable = false, length = 10)
    private String tableNo;
}
