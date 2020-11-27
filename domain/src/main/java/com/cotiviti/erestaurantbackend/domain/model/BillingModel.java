package com.cotiviti.erestaurantbackend.domain.model;

import com.cotiviti.erestaurantbackend.domain.model.base.Identity;
import lombok.Data;

import java.util.Date;

@Data
public class BillingModel extends Identity<Long> {

    private double total;

    private Date paymentDate;

    private boolean status;
}
