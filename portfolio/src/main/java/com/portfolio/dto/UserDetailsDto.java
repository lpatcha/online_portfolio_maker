package com.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDetailsDto {
	@Min(value = 1, message = "id cannot be null")
	public int id;
	
	@Min(value = 1, message = "userid cannot be null")
	public int userId;
	
	@NotNull
	@Pattern(regexp = "^\\d{10,11}$")
	public String phoneNo;
	
	@NotBlank
	public String firstName;
	
	@NotBlank
	public String lastName;
	
	public String photo;
	
	public String address;
	
	public String aboutme;
	
	@NotNull
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of birth is not in valid format")
	public String dateOfBirth;
	
	@Email
	@NotBlank
	public String email;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
