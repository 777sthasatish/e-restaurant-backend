package com.cotiviti.erestaurantbackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatorModel {
    private String username;
    private String password;

}
