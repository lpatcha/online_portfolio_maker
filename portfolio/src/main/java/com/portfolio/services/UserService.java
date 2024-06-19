package com.portfolio.services;

import com.portfolio.dto.UserDetails;
import com.portfolio.entity.UserDetailsInfo;

public interface UserService {

	
	UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails);
	
	UserDetailsInfo updateUserDetails(UserDetails userDetails);
	
}
