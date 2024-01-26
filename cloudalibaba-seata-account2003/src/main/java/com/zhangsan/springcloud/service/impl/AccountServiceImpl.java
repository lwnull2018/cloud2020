package com.zhangsan.springcloud.service.impl;

import com.zhangsan.springcloud.dao.AccountDao;
import com.zhangsan.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public int decrease(Long userId, BigDecimal money) {

        log.info("------>account.service扣余额开始");
        int result = accountDao.decrease(userId, money);
        log.info("------>account.service扣余额结束");

        return result;
    }

}
