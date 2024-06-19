package com.portfolio.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "user_details")
public class UserDetailsInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "photo")
	private String photo;
	
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "about_me")
	private String aboutMe;
	
	@Column(name = "email")
	private String email;
	
	
	@Column(name = "date_of_birth", columnDefinition = "DATE")
	private String dateOfBirth;
	
	@OneToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	
	public String getEmail() {
		return this.email;
		
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

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "UserDetailsInfo [id=" + id + ", phoneNo=" + phoneNo + ", firstName=" + firstName + ", lastName="
				+ lastName + ", photo=" + photo + ", address=" + address + ", aboutMe=" + aboutMe + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", user=" + user + "]";
	}

	
	
	
	
}
