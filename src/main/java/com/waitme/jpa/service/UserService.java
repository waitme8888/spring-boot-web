package com.waitme.jpa.service;

import java.util.List;

import com.waitme.jpa.model.User;


public interface UserService {

	void save(User user);
	
	List<User> findAll();
	
	User findById(Long id);
	
	User findUserByName(String name);
	
	User update(User user);
}
