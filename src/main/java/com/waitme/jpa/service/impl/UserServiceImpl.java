package com.waitme.jpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.waitme.jpa.model.User;
import com.waitme.jpa.repository.UserRepository;
import com.waitme.jpa.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource 
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findUserByName(String name) {
		System.out.println(name);
		User user = userRepository.findByName(name);
		return user;
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
		
	}

}
