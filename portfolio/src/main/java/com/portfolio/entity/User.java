package com.portfolio.entity;
import java.util.Collection;
import java.util.List;
import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User implements UserDetails{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "user_name")
private String userName;

@Column(name = "password")
private String password;


@OneToMany(mappedBy = "user")
private List<Education> education;

@OneToMany(mappedBy = "user")
private List<Projects> projects;

@OneToMany(mappedBy = "user")
private List<SocialMedia> socialMedia;


@OneToMany(mappedBy = "user")
private List<UserToolsAndTechnologies> userToolsAndTechnologies;


@OneToMany(mappedBy = "user")
private List<LeadInfo> leadInfo;

@OneToMany(mappedBy = "user")
private List<ActiveUsers> activeUsers;


public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public void setId(int id) {
	this.id = id;
}

public List<ActiveUsers> getActiveUsers() {
	return activeUsers;
}

public void setActiveUsers(List<ActiveUsers> activeUsers) {
	this.activeUsers = activeUsers;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
  return null;
}

public User() {
	
}

public User(String email, String password) {
	super();
	this.userName = email;
	this.password = password;
}


@Override
public boolean isAccountNonExpired() {
  return true;
}

@Override
public boolean isAccountNonLocked() {
  return true;
}

@Override
public boolean isCredentialsNonExpired() {
  return true;
}

@Override
public boolean isEnabled() {
  return true;
}


@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return this.userName;
}




public void setEmail(String userName) {
	this.userName = userName;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}



public List<Education> getEducation() {
	return education;
}


public void setEducation(List<Education> education) {
	this.education = education;
}


public List<Projects> getProjects() {
	return projects;
}


public void setProjects(List<Projects> projects) {
	this.projects = projects;
}


public List<SocialMedia> getSocialMedia() {
	return socialMedia;
}


public void setSocialMedia(List<SocialMedia> socialMedia) {
	this.socialMedia = socialMedia;
}


public List<UserToolsAndTechnologies> getUserToolsAndTechnologies() {
	return userToolsAndTechnologies;
}

public int getId() {
	return this.id;
}


public void setUserToolsAndTechnologies(List<UserToolsAndTechnologies> userToolsAndTechnologies) {
	this.userToolsAndTechnologies = userToolsAndTechnologies;
}


public List<LeadInfo> getLeadInfo() {
	return leadInfo;
}


public void setLeadInfo(List<LeadInfo> leadInfo) {
	this.leadInfo = leadInfo;
}




}
