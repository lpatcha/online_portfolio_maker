package com.portfolio.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "lead_info")
public class LeadInfo {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
int id;

@Column(name = "email")
String email;

@Column(name = "phone_no")
String phoneNo;

@Column(name = "first_name")
String firstName;

@Column(name = "last_name")
String lastName;

@Column(name = "message")
String message;

@ManyToOne(fetch =  FetchType.LAZY)
@JoinColumn(name = "user_id")
private User user;

public LeadInfo()
{
	
};

public LeadInfo(String email, String phoneNo, String firstName, String lastName, String message, User user) {
	super();
	this.email = email;
	this.phoneNo = phoneNo;
	this.firstName = firstName;
	this.lastName = lastName;
	this.message = message;
	this.user = user;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "LeadInfo [id=" + id + ", email=" + email + ", phoneNo=" + phoneNo + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", message=" + message + ", user=" + user + "]";
}





}
