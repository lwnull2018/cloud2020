package com.zhangsan.springcloud.controller;

import com.zhangsan.springcloud.service.PaymentFeignService;
import com.zhangsan.springcloud.entities.CommonResult;
import com.zhangsan.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public Object paymentFeignTimeOut() {
        //OpenFeign 客户端一般默认等待时间为1秒
        return paymentFeignService.paymentFeignTimeOut();
    }

}
