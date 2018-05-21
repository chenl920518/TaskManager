package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public User selectUser(String userName, String password) {
		return userDao.selectUser(userName, password);
	}

	@Override
	public User selectUserByName(String userName) {
		return userDao.selectUserByName(userName);
	}

	@Override
	public User findUserByName(String userName) {
		return userDao.findUserByName(userName);
	}

	@Override
	public List<User> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public List<User> selectUserByType(int roleNo) {
		return userDao.selectUserByType(roleNo);
	}
	

}
