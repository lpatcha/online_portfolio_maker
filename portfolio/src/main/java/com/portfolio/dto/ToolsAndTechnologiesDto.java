package com.portfolio.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class ToolsAndTechnologiesDto {
	
	@NotBlank
	String name;
	
	@Null(groups= OnCreateGroupValidation.class)
	@NotNull(groups = OnUpdateGroupValidation.class)
	int id;
	
	@NotNull
	int categoryId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	

}
