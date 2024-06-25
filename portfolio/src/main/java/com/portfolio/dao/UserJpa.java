package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.User;

public interface UserJpa extends JpaRepository<User, Integer>{
	User findById(int id);
}
