package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.User;

public interface UserMapper {

	List<User> queryUserByUserName(String username);

	void addUser(User user);

}
