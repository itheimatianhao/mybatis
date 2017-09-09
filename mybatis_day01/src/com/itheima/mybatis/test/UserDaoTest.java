package com.itheima.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.UserDaoImpl;
import com.itheima.mybatis.pojo.User;

public class UserDaoTest {
	private SqlSessionFactory factory;

	@Before
	public void init() throws Exception {
		// Reader inputStream = null;
		String resource = "SqlMapComfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// ---创建SqlsessionFactory--
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void queryUserByUserName() {
		UserDao ud = new UserDaoImpl(factory);
		List<User> uList = ud.queryUserByUserName();
		for (User user : uList) {
			System.out.println(user);
		}
	}

	@Test
	public void addUser() {
		UserDao ud = new UserDaoImpl(factory);
		User u = new User();
		u.setUsername("田七");
		u.setAddress("东北");
		u.setBirthday(new Date());
		u.setSex("2");
		ud.addUser(u);
	}
}
