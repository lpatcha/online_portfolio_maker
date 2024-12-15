package com.portfolio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ToolsAndTechnologiesDto {
	
	@NotBlank
	String name;
	
	 @Min(value = 1, message = "id cannot be null", groups = OnUpdateGroupValidation.class)
	 @Max(value = 0, message = "id should not be provided", groups = OnCreateGroupValidation.class)
	int id;
	
	@NotNull
	int categoryId;
	
	CategoryDto category;
	
	
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
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
