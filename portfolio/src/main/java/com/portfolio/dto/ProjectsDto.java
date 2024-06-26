package com.portfolio.dto;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;


public class ProjectsDto {

	
	
	@Min(value = 1, message = "id cannot be null", groups = OnUpdateGroupValidation.class)
	@Max(value = 0, message = "id should not be provided", groups = OnCreateGroupValidation.class)
	private int id;
	
	@NotBlank
	private String projectName;
	
	private String clientName;
	private String location;
	@NotBlank
	private  String role;
	
	@NotNull
	private Date endDate;
	
	@NotNull
	@Past
	private Date startDate;
	
	@Min(value = 1, message = "user id cannot be null")
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	

}
