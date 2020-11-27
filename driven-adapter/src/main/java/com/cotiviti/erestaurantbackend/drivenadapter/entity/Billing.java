package com.cotiviti.erestaurantbackend.drivenadapter.entity;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.base.Identity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_billing")
@Data
public class Billing extends Identity<Long> {

    @Column(nullable = false)
    private double total;

    @Column
    private Date paymentDate;

    @Column
    private boolean status;

//    @OneToMany(mappedBy = "billing")
//    private List<FoodOrder> foodOrders;
}
