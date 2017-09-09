package com.itheima.mybatis.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory factory;

	public UserDaoImpl(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public List<User> queryUserByUserName() {
		SqlSession session = factory.openSession();
		List<User> uList = session.selectList("test.queryUserByUserName", "张");
		session.close();
		return uList;
	}

	@Override
	public void addUser(User user) {
		SqlSession session = factory.openSession();
		session.insert("test.addUser", user);
		session.commit();
		session.close();
	}
}
