package com.cotiviti.erestaurantbackend.driveradapter.dto;

import com.cotiviti.erestaurantbackend.driveradapter.dto.base.Identity;
import lombok.Data;

import java.util.Date;

@Data
public class BillingDTO extends Identity<Long> {

    private double total;

    private Date paymentDate;

    private boolean status;
}
