package com.waitme.mybatis.dao;

import com.waitme.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	public User selectUserById(Long id);
	
	public int deleteUserById(Long id);
	
}