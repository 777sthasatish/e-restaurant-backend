package com.cotiviti.erestaurantbackend.driveradapter.mapper;


import com.cotiviti.erestaurantbackend.domain.model.AuthenticatorModel;
import com.cotiviti.erestaurantbackend.driveradapter.dto.AuthenticatorDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AuthenticatorMapper{
    AuthenticatorModel toModel(AuthenticatorDTO authenticatorDTO);
}
