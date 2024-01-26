package com.zhangsan.springcloud.service.impl;

import com.zhangsan.springcloud.dao.OrderDao;
import com.zhangsan.springcloud.domain.Order;
import com.zhangsan.springcloud.service.AccountService;
import com.zhangsan.springcloud.service.OrderService;
import com.zhangsan.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    public int create(Order order) {
        log.info("------>下单开始");

        //1、创建订阅
        int result = orderDao.create(order);

        //2、扣库存
        log.info("------>order-service扣减库存开始");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------>order-service扣减库存结束");

        //3、减余额
        log.info("------>order-service扣减余额开始");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------>order-service扣减余额开始");

        //4、修改订单状态
        log.info("------>修改订单状态开始");
        orderDao.update(order.getId(), order.getStatus());
        log.info("------>修改订单状态结束");

        log.info("------>下单结束");

        return result;
    }

    @Override
    public int update(Long id, int status) {
        return orderDao.update(id, status);
    }

}
