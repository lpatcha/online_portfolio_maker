package com.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "active_users")
public class ActiveUsers {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "token")
private String token;

@Column(name = "active")
private boolean active;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
private User user;

public ActiveUsers() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public boolean getActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

	
}



