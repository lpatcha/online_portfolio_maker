package com.portfolio.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.config.TokenProvider;
import com.portfolio.dao.ActiveUser;
import com.portfolio.dao.UserDao;
import com.portfolio.dto.ResetPasswordDto;
import com.portfolio.dto.SignUpDto;
import com.portfolio.entity.ActiveUsers;
import com.portfolio.entity.User;
import com.portfolio.entity.UserDetailsInfo;
import com.portfolio.exceptionHandling.InvalidJwtException;

import jakarta.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService, UserDetailsService{
	@Autowired
	UserDao userDaoImpl;
	
	@Autowired 
	ActiveUser activeUser;
	
	@Autowired 
	UserDao userDao;
	
	
	@Autowired
	TokenProvider tokenProvider;
	
		
		@Override
		public User getUserByUserName(String userName){
			return userDaoImpl.findUserByUserName(userName);
		}
	
	@Override
	
	 public User signUp(SignUpDto data) throws InvalidJwtException {
		    if (userDaoImpl.findUserByUserName(data.getUserName()) != null) {
		      throw new InvalidJwtException("Username already exists");
		    }
		    String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
		    User newUser = new User(data.getUserName(), encryptedPassword);
		    UserDetailsInfo userDetailsInfo = new UserDetailsInfo();
		    userDetailsInfo.setEmail(data.getEmail());
		    return userDaoImpl.saveUser(newUser, userDetailsInfo);
		  }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDaoImpl.findUserByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException(String.format("User does not exist, email: %s", username));
			
		}
		  return org.springframework.security.core.userdetails.User.builder()
			        .username(user.getUsername())
			        .password(user.getPassword())
			        .build();
	}

	@Override
	@Transactional
	public void insertUpdateTokenActiveUsers(String userName, String token) {
		User user = userDaoImpl.findUserByUserName(userName);
		//check in active user table if a user already exists or not
		ActiveUsers retrivedActiveUser =  activeUser.findActiveUserByUser(user);
		
		ActiveUsers newActiveUser = new ActiveUsers();
		if(retrivedActiveUser == null) {
			//insert new record in active user entity
			newActiveUser.setActive(true);
			newActiveUser.setToken(token);
			newActiveUser.setUser(user);
			
		}
		else {
			//update existing entity
			newActiveUser.setActive(retrivedActiveUser.getActive());
			newActiveUser.setToken(token);
			newActiveUser.setUser(retrivedActiveUser.getUser());
			newActiveUser.setId(retrivedActiveUser.getId());
		}
		
	    activeUser.createUpdateActiveUser(newActiveUser);
	}

	@Override
	@Transactional
	public void logoutUser(int userId) {
		
		User user = userDao.findUserById(userId);
		//get user from
		activeUser.deleteActiveUserById(user);
		
	}
	
	@Override
	@Transactional
	public String resetPassword(String token, ResetPasswordDto resetPasswordDto) throws InvalidJwtException {
		String userName = tokenProvider.decryptingToken(token);
		
		
		// check for vaild old password 
		String oldPassword = resetPasswordDto.getOldPassword();
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		String newEncryptedPassword = new BCryptPasswordEncoder().encode(resetPasswordDto.getNewPassword());
		User user = userDao.findUserByUserName(userName);
		String accessToken;
		// yes - reset password
		
		if(b.matches(oldPassword, user.getPassword())) {
			user.setPassword(newEncryptedPassword);
			userDao.updateUser(user);
			// generate new token
			accessToken = tokenProvider.generateAccessToken(userName);
			insertUpdateTokenActiveUsers(userName, accessToken);
			
		}
		else {
			
			throw new InvalidJwtException("Incorrect old password please try again");
			
		}
		
		return accessToken;
	}
	
	
	 
	
}

