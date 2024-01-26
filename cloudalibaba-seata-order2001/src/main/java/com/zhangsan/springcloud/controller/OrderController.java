package com.zhangsan.springcloud.controller;

import com.zhangsan.springcloud.domain.Order;
import com.zhangsan.springcloud.entities.CommonResult;
import com.zhangsan.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}
