package com.waitme.jpa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waitme.jpa.model.User;
import com.waitme.jpa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}

	@RequestMapping("/name/{name}")
	public User getUserByName(@PathVariable("name") String name) {
		return userService.findUserByName(name);
	}

	@RequestMapping("/list")
	public List<User> getUsers() {
		return userService.findAll();
	}

	@RequestMapping("/save")
	public User updateUser(User user) {
		return userService.update(user);
	}

}
