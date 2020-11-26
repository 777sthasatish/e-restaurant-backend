package com.cotiviti.erestaurantbackend.driveradapter.dto;

import lombok.Data;

@Data
public class MenuDTO {

    private String name;

    private String path;

    private int order;

    private String icon;

    private boolean enabled;
}
