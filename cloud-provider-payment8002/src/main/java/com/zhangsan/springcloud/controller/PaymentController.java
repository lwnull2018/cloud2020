package com.zhangsan.springcloud.controller;

import com.zhangsan.springcloud.entities.CommonResult;
import com.zhangsan.springcloud.entities.Payment;
import com.zhangsan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //引入端口，方便观察哪个程序在提供服务
    @Value("${server.port}")
    private int port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：{}", result);

        if (result > 0) {
            return new CommonResult(200, "插入成功", payment);
        } else {
            return new CommonResult(500, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功，server,port: " + port, payment);
        } else {
            return new CommonResult(404, "没有对应记录，查询ID：" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public Object getPaymentBL() {
        return port;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public Object paymentTimeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return port;
    }

}
