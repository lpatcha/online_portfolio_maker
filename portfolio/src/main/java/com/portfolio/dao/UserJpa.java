package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.entity.User;

public interface UserJpa extends JpaRepository<User, Integer>{
	User findById(int id);
	User findByUserName(String userName);
	 @Query("select u from User u "
	 		+ "Left Join u.education "
	 		+ "Left Join u.projects "
	 		+ "Left Join u.socialMedia "
	 		+ "Left Join u.userToolsAndTechnologies "
	 		+ "where u.id = ?1")
	 User findAllUserDetails(int id);
	 
	
}
