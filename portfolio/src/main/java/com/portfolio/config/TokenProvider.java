package com.portfolio.config;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.portfolio.dao.ActiveUser;
import com.portfolio.dao.UserDao;
import com.portfolio.entity.ActiveUsers;
import com.portfolio.entity.User;
import com.portfolio.utils.ResponseMessages;

import jakarta.transaction.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenProvider {
	
@Autowired
UserDao userDao;

@Autowired
ActiveUser activeUser;


	
private String JWT_SECRET = ResponseMessages.SUCCESS_MESSAGE;

public String generateAccessToken(String userName) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
      return JWT.create()
          .withSubject(userName)
          .withClaim("username", userName)
          .withExpiresAt(genAccessExpirationDate())
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      throw new JWTCreationException("Error while generating token", exception);
    }
  }

@Transactional
public String validateToken(String token) {
    try {
     
      String userName = decryptingToken(token);
      checkForLogoutUser(userName,token);
      return userName;
    
    } catch (JWTVerificationException exception) {
    
      //remove active user
   
    	
      throw new JWTVerificationException("Error while validating token", exception);
    }
  }


public String decryptingToken(String token) {
	 Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
     String userName = JWT.require(algorithm)
             .build()
             .verify(token)
             .getSubject();
     //todo check if user is valid or not
    
     
     return userName;
	
}



public void checkForLogoutUser(String userName, String token) {
	//find user using user name
	User user  = userDao.findUserByUserName(userName);

	//retrive active user
	ActiveUsers newActiveUser = activeUser.findActiveUserByUser(user);
	
	// if null throw error
	// match token for unmatched tokens throw error
	if((newActiveUser == null) || !(newActiveUser.getToken().equals(token))) {
		
		long userId = user.getId();

		throw new JWTVerificationException("Error while validating token");
	}
}




private Instant genAccessExpirationDate() {
    return LocalDateTime.now().plusHours(2).atZone(ZoneId.of("America/New_York")).toInstant();
  }


}
