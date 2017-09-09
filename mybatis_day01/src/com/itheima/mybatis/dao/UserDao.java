package com.itheima.mybatis.dao;

import java.util.List;

import com.itheima.mybatis.pojo.User;

public interface UserDao {
	/**
	 * 模糊查询
	 */
	List<User> queryUserByUserName();

	void addUser(User user);
}
