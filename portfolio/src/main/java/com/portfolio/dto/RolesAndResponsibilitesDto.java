package com.portfolio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class RolesAndResponsibilitesDto {
	@Min(value = 1, groups= OnUpdateGroupValidation.class)
	@Max(value = 0, groups = OnCreateGroupValidation.class)
	int id;
	
	@NotBlank
	String description;
	
	@Min(value = 1)
	int projectId;
	
	public int getId() {	
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
}
