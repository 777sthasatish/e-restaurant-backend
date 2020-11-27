package com.cotiviti.erestaurantbackend.drivenadapter.entity;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.base.Identity;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@javax.persistence.Table(name = "tbl_food_order")
public class FoodOrder extends Identity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Billing billing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_menu_id")
    private FoodMenu foodMenu;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private Table table;

    @Column(nullable = false)
    @CreatedDate
    private Date orderDate;

    @PrePersist
    public  void setOrderDate() {
        this.orderDate = new Date();
    }
}