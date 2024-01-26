package com.zhangsan.springcloud.service;

import com.zhangsan.springcloud.domain.Order;

public interface OrderService {

    int create(Order order);

    int update(Long id, int status);
}
