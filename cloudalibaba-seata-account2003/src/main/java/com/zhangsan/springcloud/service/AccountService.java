package com.zhangsan.springcloud.service;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * 扣余额
     * @param userId
     * @param money
     * @return
     */
    int decrease(Long userId, BigDecimal money);

}
