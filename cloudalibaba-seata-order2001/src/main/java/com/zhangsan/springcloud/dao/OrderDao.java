package com.zhangsan.springcloud.dao;

import com.zhangsan.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    /**
     * 新建订单
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 修改订单状态
     * @param id
     * @param status
     * @return
     */
    int update(@Param("id") Long id, @Param("status") int status);
}
