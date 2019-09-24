package com.xt.gmall.service.impl;

import com.xt.gmall.bean.UserAddress;
import com.xt.gmall.service.UserService;

import java.util.List;

/**
 * 本地存根
 */
public class UserServiceStub implements UserService {
    private final UserService userService;

    /**
     * 传入的是远程 UserService 的代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("====UserServiceStub====");
        if (!userId.isEmpty()) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
