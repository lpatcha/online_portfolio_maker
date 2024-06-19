package com.portfolio.dto;

public class JwtDto {
   public String jwtToken;
   public String userName;
   public JwtDto(String jwtToken, String userName) {
	   this.jwtToken = jwtToken;
	   this.userName = userName;
   }
public String getJwtToken() {
	return jwtToken;
}
public void setJwtToken(String jwtToken) {
	this.jwtToken = jwtToken;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
   
}
