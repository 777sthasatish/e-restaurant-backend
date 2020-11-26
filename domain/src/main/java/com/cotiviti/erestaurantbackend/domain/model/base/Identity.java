package com.cotiviti.erestaurantbackend.domain.model.base;

import lombok.Data;

@Data
public class Identity<T> {
    T id;
}
