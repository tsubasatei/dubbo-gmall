package com.xt.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xt.gmall.bean.UserAddress;
import com.xt.gmall.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service // 暴露服务 第一种方式
@Component
public class UserServiceImpl implements UserService {

	@HystrixCommand
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl..3.....");
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

		// 暂停一会儿线程
//		try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
		if (Math.random() > 0.5) {
			throw new RuntimeException();
		}
		return Arrays.asList(address1, address2);
	}
}
