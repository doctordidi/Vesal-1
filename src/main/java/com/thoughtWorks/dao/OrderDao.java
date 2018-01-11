package com.thoughtWorks.dao;

import com.thoughtWorks.entity.Order;

/**
 * @author 马欢欢
 * @date 18-1-10
 */
public interface OrderDao {
    /**
     * 添加一个订单
     * @param order
     * @throws Exception
     */
    void addOrder(Order order)throws Exception;

    /**
     * 查找商品是否已经添加到购物车
     * @param order
     * @return
     * @throws Exception
     */
    int queryAddOrder(Order order)throws Exception;
}
