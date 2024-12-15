package com.portfolio.dto;

public class JwtDto {
   public String jwtToken;
   public String userName;
   int id;
   
   
   public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public JwtDto(String jwtToken, String userName, int id) {
	   this.jwtToken = jwtToken;
	   this.userName = userName;
	   this.id = id;
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
