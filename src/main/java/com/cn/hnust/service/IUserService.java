package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.User;
/**
 * 用户Service 接口
 * @author Administrator
 *
 */
public interface IUserService {
	 User selectUser(String userName,String password);
	
	 User selectUserByName(String trueName);
	
	 User findUserByName(String userName);
	
	 List<User> selectAllUser();
	 
	 List<User> selectUserByType(int roleNo);
	
}
