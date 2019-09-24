package com.xt.gmall.service;

import com.xt.gmall.bean.UserAddress;

import java.util.List;

/**
 * 订单服务
 */
public interface OrderService {
    /**
     * 初始化订单
     * @param userId：用户Id
     */
    List<UserAddress> initOrder(String userId);
}
