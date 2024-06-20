package com.portfolio.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.portfolio.dao.UserDao;
import com.portfolio.dto.SignUpDto;
import com.portfolio.entity.User;
import com.portfolio.entity.UserDetailsInfo;
import com.portfolio.exceptionHandling.InvalidJwtException;

@Service
public class AuthServiceImpl implements AuthService, UserDetailsService{
	@Autowired
	UserDao userDaoImpl;
		
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
	 
	
}

