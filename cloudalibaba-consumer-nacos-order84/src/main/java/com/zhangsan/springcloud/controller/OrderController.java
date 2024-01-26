package com.zhangsan.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhangsan.springcloud.entities.CommonResult;
import com.zhangsan.springcloud.entities.Payment;
import com.zhangsan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    public RestTemplate restTemplate;

    /**
     * 只负责业务异常处理，其他异常由兜底方法统一处理
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler"
        , exceptionsToIgnore = IllegalArgumentException.class)  //忽略指定异常
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {

        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常。。。");
        } else if (id > 4){
            throw new NullPointerException("NullPointerException 该ID没有对应记录，空指针异常");
        }

        return result;
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "blockHandler异常，异常内容：" + e.getMessage(), payment);
    }

    /**
     * 兜底方法
     * @param id
     * @param throwable
     * @return
     */
    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable throwable) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底异常handlerFallback，exception内容 " + throwable.getMessage(), payment);
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/openfegin/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

}
