package com.cotiviti.erestaurantbackend.driveradapter.controller.secured;

import com.cotiviti.erestaurantbackend.domain.port.driver.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.cotiviti.erestaurantbackend.driveradapter.utils.ApiPathConstant.*;

@RestController
@RequestMapping(BASE_PATH_V1 + CHECK_OUT)
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentUseCase paymentUseCase;

    @PatchMapping(ID_PATH)
    public void checkOut(@PathVariable String id) {
        paymentUseCase.checkout(id);
    }
}
