package com.cotiviti.erestaurantbackend.domain.model;

import com.cotiviti.erestaurantbackend.domain.model.base.Identity;
import lombok.Data;

@Data
public class TableModel extends Identity<Long> {
    private String tableNo;
}
