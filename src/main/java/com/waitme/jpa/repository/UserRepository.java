package com.waitme.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.waitme.jpa.model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("from User u where u.name=:name")
	User findByName(@Param("name") String name);
	


}
