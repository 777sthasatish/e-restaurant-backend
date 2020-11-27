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

    @Override
    public List<FoodOrderModel> getAllPending() {
        return foodOrderMapper.toModels(foodOrderRepository.getAllPending());
    }

    @Override
    public List<FoodOrderModel> getAllPendingBy(String id) {
        var test = foodOrderRepository.getAllPendingBy(id);
        return foodOrderMapper.toModels(foodOrderRepository.getAllPendingBy(id));
    }

    private Billing saveBilling(FoodOrderModel foodOrderModel) {
        Optional<FoodOrder> optionalFoodOrder = foodOrderRepository.getPendingBillOf(foodOrderModel.getTable().getId());
        if(optionalFoodOrder.isPresent()) {
            FoodOrder foodOrder = optionalFoodOrder.get();
            Billing billing = foodOrder.getBilling();
            double total = billing.getTotal() + (foodOrderModel.getQuantity() * foodOrderModel.getFoodMenu().getPrice());
            billing.setTotal(total);
            return billing;
        } else {
            final double total = foodOrderModel.getQuantity() * foodOrderModel.getFoodMenu().getPrice();
            return addBill(total);
        }
    }

    private Billing addBill(double total) {
        Billing billing = new Billing();
        billing.setStatus(false);
        billing.setTotal(total);
        return billingRepository.save(billing);
    }

    private Billing updateBill(double total, long billId) {
        Billing billing = billingRepository.findById(billId).orElse(new Billing());
        billing.setTotal(total);
        return billing;
    }
}
