package com.cn.hnust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.User;

public interface IUserDao {
   
    User selectUser(@Param("userName")String userName,@Param("password")String password);
    
    User selectUserByName(String userName);

	User findUserByName(String userName);

	List<User> selectAllUser();
	
	List<User> selectUserByType(@Param("roleNo")int roleNo);
	

}