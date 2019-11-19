package com.xt.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xt.gmall.bean.UserAddress;
import com.xt.gmall.service.OrderService;
import com.xt.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
//    @Reference(url="127.0.0.1:20880")  // dubbo 直连
    @Reference(loadbalance="random", timeout=1000) // 负载均衡
    UserService userService;
    // 查询用户的收货地址
    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户ID: " + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }
    
    public List<UserAddress> hello(String userId) {
        return Arrays.asList(new UserAddress(0, "测试地址", "0", "测试", "测试", "Y"));
    }
}
