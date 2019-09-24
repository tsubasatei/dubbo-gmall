package com.xt.gmall.service;

import java.util.List;

import com.xt.gmall.bean.UserAddress;

/**
 * 用户服务
 *
 */
public interface UserService {
	
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId : 用户 Id
	 * @return
	 */
	List<UserAddress> getUserAddressList(String userId);

}
