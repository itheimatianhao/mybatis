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
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;

public class UserMapperTest {
	private SqlSessionFactory factory;

	@Before
	public void init() throws Exception {
		String resource = "SqlMapComfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// ---创建SqlsessionFactory--
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void queryUserByUserName() {
		SqlSession session = factory.openSession();
		// 从sqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> uList = userMapper.queryUserByUserName("张");
		for (User user : uList) {
			System.out.println(user);
		}
		session.close();
	}

	@Test
	public void addUser() {
		SqlSession session = factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setUsername("田七");
		u.setAddress("东北");
		u.setBirthday(new Date());
		u.setSex("2");
		userMapper.addUser(u);
		session.commit();
		session.close();
	}
}
