package com.portfolio.dto;

import java.sql.Date;

public class EducationDto {
 String degree;
 String description;
 String institutionName;
 double cgpa;
 double maxCgpa;
 Date startDate;
 Date endDate;
 int userId;
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
