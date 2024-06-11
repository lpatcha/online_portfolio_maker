package com.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dao.UserDao;
import com.portfolio.entity.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails saveUserDetails(UserDetails userDetails) {
		return userDao.saveUserDetails(userDetails);
		
	}

}
