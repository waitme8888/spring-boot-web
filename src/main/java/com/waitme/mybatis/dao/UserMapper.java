package com.waitme.mybatis.dao;

import com.waitme.mybatis.model.User;

public interface UserMapper {
	
	public User selectUserById(Long id);
	
	public int deleteUserById(Long id);
	
}