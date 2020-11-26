package com.cotiviti.erestaurantbackend.domain.model;

import com.cotiviti.erestaurantbackend.domain.model.base.Identity;
import lombok.Data;

@Data
public class MenuModel extends Identity<Long> {
    private String name;
    private String path;
    private int order;
    private String icon;
    private boolean enabled;
}
