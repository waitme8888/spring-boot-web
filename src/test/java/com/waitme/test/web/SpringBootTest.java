package com.waitme.test.web;

import java.util.List;

import javax.annotation.Resource;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.waitme.Application;
import com.waitme.jpa.model.User;
import com.waitme.jpa.repository.UserRepository;
import com.waitme.mybatis.dao.UserMapper;
import com.waitme.mybatis.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SpringBootTest {
	
	@Resource 
	private UserRepository userRepository;
	
	@Resource
	private UserMapper userMapper;
	
	@Resource(name="mybatisUserService")
	private UserService userService;

	@Resource(name="userService")
	private com.waitme.jpa.service.UserService jpaUserService;

	@Resource
	RedisTemplate<Object, Object> redisTemplate;

	
	@Test
	public void jpaTest() {
		List<User> users = userRepository.findAll();
		if (users!=null && !users.isEmpty()) {
			for (User user : users) {
				System.out.println(user.getName());
			}
		}
		
	}
	
	@Test
	public void mybatisTest() {

		com.waitme.mybatis.model.User user = userMapper.selectUserById(2L);
		if (user != null) {
			System.out.println(user.getName());
		}
	}
	
	@Test
	public void mybatisTransactionTest() {
		userService.deleteTransaction(3L);
	}

	@Test
	public void jpaTransactionTest() {
		jpaUserService.deleteUser(3L);
	}

	@Test
	public void redisTest() {
		this.redisTemplate.setKeySerializer(this.redisTemplate.getStringSerializer());
		String key = "stringKey";
		String value = "stringValue";
		this.redisTemplate.opsForValue().set(key, value);
		System.out.println(this.redisTemplate.opsForValue().get(key));
	}

}
