package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.ActiveUsers;
import com.portfolio.entity.User;


@Repository
public class ActiveUserImpl implements ActiveUser{

	@Autowired
	ActiveUserJpa activeUserJpa;
	
	@Override
	public boolean createUpdateActiveUser(ActiveUsers activeUsers) {
		
		activeUserJpa.save(activeUsers);
		
		return true;
	}

	@Override
	public ActiveUsers findActiveUserByUser(User user) {
		return activeUserJpa.findByUser(user);
		
		
	}

	@Override
	public void deleteActiveUserById(User user) {
		activeUserJpa.deleteByUser(user);
	}

}
