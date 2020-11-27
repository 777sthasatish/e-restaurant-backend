package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.model.FoodOrderModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.FoodOrderRepoPort;
import com.cotiviti.erestaurantbackend.drivenadapter.entity.Billing;
import com.cotiviti.erestaurantbackend.drivenadapter.entity.FoodOrder;
import com.cotiviti.erestaurantbackend.drivenadapter.mapper.FoodOrderMapper;
import com.cotiviti.erestaurantbackend.drivenadapter.repository.BillingRepository;
import com.cotiviti.erestaurantbackend.drivenadapter.repository.FoodOrderRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
@RequiredArgsConstructor
public class FoodOrderAdapter implements FoodOrderRepoPort {

    private final FoodOrderRepository foodOrderRepository;
    private final BillingRepository billingRepository;
    private final FoodOrderMapper foodOrderMapper = Mappers.getMapper(FoodOrderMapper.class);

    @Override
    public FoodOrderModel add(FoodOrderModel foodOrderModel) {
        FoodOrder foodOrder = foodOrderMapper.toEntity(foodOrderModel);
        foodOrder.setBilling(saveBilling(foodOrderModel));
        return foodOrderMapper.toModel(foodOrderRepository.save(foodOrder));
    }

    private Billing saveBilling(FoodOrderModel foodOrderModel) {
        List<FoodOrder> foodOrders = foodOrderRepository.getPendingBillOf(foodOrderModel.getTable().getId());
        if(!foodOrders.isEmpty()) {
            return updateBill(billsSum(foodOrders),foodOrders.get(0).getBilling().getId());
        } else {
            final double total = foodOrderModel.getQuantity() * foodOrderModel.getFoodMenu().getPrice();
            return addBill(total);
        }
    }

    private double billsSum(List<FoodOrder> foodOrders) {
        return foodOrders
                .stream()
                .mapToDouble(value -> value.getFoodMenu().getPrice() * value.getQuantity())
                .reduce(0, Double::sum);
    }

    private Billing addBill(double total) {
        Billing billing = new Billing();
        billing.setStatus(false);
        billing.setTotal(total);
        return billingRepository.save(billing);
    }

    private Billing updateBill(double total, long billId) {
        Optional<Billing> optionalBilling = billingRepository.findById(billId);
        Billing billing = new Billing();
        if(optionalBilling.isPresent()) {
            billing = optionalBilling.get();
            billing.setTotal(billing.getTotal() + total);
        }
        return billing;
    }
}
