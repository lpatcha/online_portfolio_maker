package com.portfolio.entity;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "user_name")
private String userName;

@Column(name = "password")
private String password;

@OneToOne(mappedBy = "user")
private UserDetails userDetails;

@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
private List<Education> education;

@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
private List<Projects> projects;

@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
private List<SocialMedia> socialMedia;


@OneToMany(mappedBy = "user", fetch = FetchType.EAGER	)
private List<UserToolsAndTechnologies> userToolsAndTechnologies;


@OneToMany(mappedBy = "user")
private List<LeadInfo> leadInfo;


public String getUserName() {
	return userName;
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


public UserDetails getUserDetails() {
	return userDetails;
}


public void setUserDetails(UserDetails userDetails) {
	this.userDetails = userDetails;
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


public void setUserToolsAndTechnologies(List<UserToolsAndTechnologies> userToolsAndTechnologies) {
	this.userToolsAndTechnologies = userToolsAndTechnologies;
}


public List<LeadInfo> getLeadInfo() {
	return leadInfo;
}


public void setLeadInfo(List<LeadInfo> leadInfo) {
	this.leadInfo = leadInfo;
}


public User(String email, String password) {
	super();
	this.userName = email;
	this.password = password;
}


@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", userDetails=" + userDetails
			+ ", education=" + education + ", projects=" + projects + ", socialMedia=" + socialMedia
			+ ", userToolsAndTechnologies=" + userToolsAndTechnologies + ", leadInfo=" + leadInfo + "]";
}




}
