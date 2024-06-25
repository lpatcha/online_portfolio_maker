package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.ActiveUsers;
import com.portfolio.entity.User;

public interface ActiveUserJpa extends JpaRepository<ActiveUsers, Long> {

	ActiveUsers findByUser(User user);

	void deleteByUser(User user);
	 
	}
