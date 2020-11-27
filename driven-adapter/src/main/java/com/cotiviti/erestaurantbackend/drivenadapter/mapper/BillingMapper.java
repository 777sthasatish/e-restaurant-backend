package com.cotiviti.erestaurantbackend.drivenadapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.BillingModel;
import com.cotiviti.erestaurantbackend.drivenadapter.entity.Billing;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BillingMapper {
    List<BillingModel> toModels(List<Billing> billings);
    BillingModel toModel(Billing billing);

    List<Billing> toEntities(List<BillingModel> billings);
    Billing toEntity(BillingModel billing);

}
