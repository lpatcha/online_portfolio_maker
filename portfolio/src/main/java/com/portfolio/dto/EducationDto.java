package com.portfolio.dto;
import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;


public class EducationDto {

@NotBlank
 String degree;

 String description;
 
 @NotBlank
 String institutionName;
 
 @Max(4)
 @Min(0)
 double cgpa;
 
 @Max(4)
 @Min((long) 0.0)
 double maxCgpa;
 
 @Past
 Date startDate;
 
 @Past
 Date endDate;
 
 @Min(value = 1, message = "Userid cannot be null")
 int userId;
 

 @Min(value = 1, message = "id cannot be null", groups = OnUpdateGroupValidation.class)
 @Max(value = 0, message = "id should not be provided", groups = OnCreateGroupValidation.class)
 int id;
 
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getInstitutionName() {
	return institutionName;
}
public void setInstitutionName(String institutionName) {
	this.institutionName = institutionName;
}
public double getCgpa() {
	return cgpa;
}
public void setCgpa(double cgpa) {
	this.cgpa = cgpa;
}
public double getMaxCgpa() {
	return maxCgpa;
}
public void setMaxCgpa(double maxCgpa) {
	this.maxCgpa = maxCgpa;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 
 
 
}
