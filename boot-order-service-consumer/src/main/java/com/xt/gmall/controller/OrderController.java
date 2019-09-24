package com.xt.gmall.controller;

import com.xt.gmall.bean.UserAddress;
import com.xt.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @GetMapping("/initOrder/{userId}")
    public List<UserAddress> initOrder(@PathVariable("userId") String userid) {
        List<UserAddress> userAddresses = orderService.initOrder(userid);
        return userAddresses;
    }
}
