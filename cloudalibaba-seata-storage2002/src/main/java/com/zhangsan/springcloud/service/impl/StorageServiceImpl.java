package com.zhangsan.springcloud.service.impl;

import com.zhangsan.springcloud.dao.StorageDao;
import com.zhangsan.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public int decrease(Long productId, int count) {
        log.info("------>storage.service中扣减库存开始");
        int result = storageDao.decrease(productId, count);
        log.info("------>storage.service中扣减库存结束");
        return result;
    }

}
