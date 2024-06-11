package com.portfolio.dao;

import org.springframework.stereotype.Repository;

import com.portfolio.entity.UserDetails;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
public class UserDaoImpl implements UserDao{
	
	private EntityManager entityManager;
	

	@Override
	@Transactional
	public UserDetails saveUserDetails(UserDetails userDetails) {
		entityManager.persist(userDetails);
		
		return userDetails;
	}

	
}
