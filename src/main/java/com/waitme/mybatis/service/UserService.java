package com.waitme.mybatis.service;

import com.waitme.mybatis.model.User;

public interface UserService {
	
	public User selectUserById(Long id);
	
	public void deleteTransaction(Long id);
	
}
