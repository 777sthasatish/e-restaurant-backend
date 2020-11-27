package com.cotiviti.erestaurantbackend.domain.port.driven;

import com.cotiviti.erestaurantbackend.domain.model.BillingModel;
import com.cotiviti.erestaurantbackend.domain.port.BillingPort;

public interface BillingRepoPort extends BillingPort {
    BillingModel save(BillingModel billingModel);
}
