package com.portfolio.dto;

public class UserToolsAndTechnologiesDto {

	int id;
	int userId;
	int proficiencyRating;
	String description;
	int toolId;
	
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
	public int getProficiencyRating() {
		return proficiencyRating;
	}
	public void setProficiencyRating(int proficiencyRating) {
		this.proficiencyRating = proficiencyRating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setToolId(int toolId) {
		this.toolId = toolId;
	}
	public int getToolId() {
		return this.toolId;
	}
	
}
