package com.waitme.mybatis.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waitme.mybatis.dao.UserMapper;
import com.waitme.mybatis.model.User;
import com.waitme.mybatis.service.UserService;


@Service("mybatisUserService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public User selectUserById(Long id) {
		return userMapper.selectUserById(id);
	}

	@Transactional()
	@Override
	public void deleteTransaction(Long id) {
		User user = userMapper.selectUserById(id);
		System.out.println(user.getName());
		userMapper.deleteUserById(user.getId());
		throw new RuntimeException();
		
	}
	
	
	
}
