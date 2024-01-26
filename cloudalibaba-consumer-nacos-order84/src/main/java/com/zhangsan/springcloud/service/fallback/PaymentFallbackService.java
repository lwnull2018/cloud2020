package com.zhangsan.springcloud.service.fallback;

import com.zhangsan.springcloud.entities.CommonResult;
import com.zhangsan.springcloud.entities.Payment;
import com.zhangsan.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级熔断", new Payment(id, "errorSerial"));
    }

}
