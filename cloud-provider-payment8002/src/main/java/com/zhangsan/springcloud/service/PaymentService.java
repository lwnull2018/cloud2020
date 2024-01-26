package com.zhangsan.springcloud.service;

import com.zhangsan.springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
