package com.portfolio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class UserToolsAndTechnologiesDto {

	@Min(value = 1, message = "id cannot be null", groups= OnUpdateGroupValidation.class)
	@Max(value = 0, message = "id filed should not be present", groups = OnCreateGroupValidation.class)
	int id;
	
	@Min(value = 1, message = "userid cannot be null")
	int userId;
	
	@Max(10)
	int proficiencyRating;
	
	String description;
	
	ToolsAndTechnologiesDto toolsAndTechnology;
	
	
	public ToolsAndTechnologiesDto getToolsAndTechnology() {
		return toolsAndTechnology;
	}
	public void setToolsAndTechnology(ToolsAndTechnologiesDto toolsAndTechnology) {
		this.toolsAndTechnology = toolsAndTechnology;
	}
	@Min(value = 1, message = "toolId cannot be null")
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
