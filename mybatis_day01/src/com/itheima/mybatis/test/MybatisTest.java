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

import com.itheima.mybatis.pojo.User;

public class MybatisTest {
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
	public void queryUserByID() {
		// ---获取session---
		SqlSession session = factory.openSession();
		User user = session.selectOne("test.queryUserById", 10);
		// System.out.println(user);
		System.err.println(user);
		// ---释放资源---
		session.close();
	}

	@Test
	public void queryUserByUserName() {
		// ---获取session---
		SqlSession session = factory.openSession();
		List<User> uList = session.selectList("test.queryUserByUserName", "张");
		for (User user : uList) {
			System.out.println(user);
		}
		session.close();
	}

	@Test
	public void addUser() {
		SqlSession session = factory.openSession();
		User u = new User();
		u.setUsername("田七");
		u.setAddress("东北");
		u.setBirthday(new Date());
		u.setSex("2");
		session.insert("test.addUser", u);
		session.commit();
		session.close();
	}

	@Test
	public void deleteUserById() {
		SqlSession session = factory.openSession();
		session.delete("deleteUserById", 27);
		session.commit();
		session.close();
	}

	@Test
	public void updateUser() {
		SqlSession session = factory.openSession();
		User user = session.selectOne("test.queryUserById", 28);
		user.setUsername("小沈阳");
		session.update("updateUser", user);
		session.commit();
		session.close();
	}
}
