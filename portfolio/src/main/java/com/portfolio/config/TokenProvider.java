package com.portfolio.config;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import com.portfolio.utils.ResponseMessages;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

@Service
public class TokenProvider {
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

public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
      return JWT.require(algorithm)
          .build()
          .verify(token)
          .getSubject();
    } catch (JWTVerificationException exception) {
      throw new JWTVerificationException("Error while validating token", exception);
    }
  }




private Instant genAccessExpirationDate() {
    return LocalDateTime.now().plusHours(2).atZone(ZoneId.of("America/New_York")).toInstant();
  }


}
