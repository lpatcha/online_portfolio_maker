package com.portfolio.services;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.portfolio.dto.SignUpDto;
import com.portfolio.entity.User;
import com.portfolio.exceptionHandling.InvalidJwtException;

public interface AuthService extends UserDetailsService{
	User getUserByUserName(String userName);
	User signUp(SignUpDto data) throws InvalidJwtException;

}
