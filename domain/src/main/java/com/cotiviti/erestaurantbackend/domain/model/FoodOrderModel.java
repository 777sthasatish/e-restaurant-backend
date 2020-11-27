package com.cotiviti.erestaurantbackend.domain.model;

import com.cotiviti.erestaurantbackend.domain.model.base.Identity;
import lombok.Data;

import java.util.Date;

@Data
public class FoodOrderModel extends Identity<Long> {

    private BillingModel billing;

    private FoodMenuModel foodMenu;

    private int quantity;

    private TableModel table;

    private Date orderDate;
}
