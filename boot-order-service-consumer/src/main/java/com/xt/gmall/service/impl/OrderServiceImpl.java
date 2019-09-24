package com.xt.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xt.gmall.bean.UserAddress;
import com.xt.gmall.service.OrderService;
import com.xt.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单服务
 * 1. 将服务提供者注册到服务中心（暴露服务）
 *      1) 导入 dubbo 依赖（2.6.2）\ 操作 zookeeper 的客户端 （curator）
 *      2） 配置服务提供者
 * 2. 让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Reference
    UserService userService;
    // 查询用户的收货地址
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户ID: " + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : userAddressList) {
            System.out.println(userAddress);
        }
        return userAddressList;
    }
}
