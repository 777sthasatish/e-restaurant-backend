package com.cotiviti.erestaurantbackend.driveradapter.dto;

import com.cotiviti.erestaurantbackend.driveradapter.dto.base.Identity;
import lombok.Data;

@Data
public class TableDTO extends Identity<Long> {
    private String tableNo;
}
