package com.portfolio.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.User;
import com.portfolio.entity.UserDetailsInfo;

public interface UserDetailsJpa extends JpaRepository<UserDetailsInfo, Integer>{
	
	UserDetailsInfo findByUser(User user);
	
}
