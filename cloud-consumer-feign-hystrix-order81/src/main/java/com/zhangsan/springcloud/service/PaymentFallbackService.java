package com.zhangsan.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 统一的 Fallback 异常处理类
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String payment_OK(Integer id) {
        return "PaymentFallbackService ---- payment_OK 服务发生异常，请稍后再试";
    }

    @Override
    public String payment_TimeOut(Integer id) {
        return "PaymentFallbackService ---- payment_TimeOut 服务发生异常，请稍后再试";
    }

}
