package com.cotiviti.erestaurantbackend.driveradapter.dto.base;

import lombok.Data;

@Data
public class Identity<T> {
    private T id;
}
