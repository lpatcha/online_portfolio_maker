package com.portfolio.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CategoryDto {

	@Min(value = 1, groups= OnUpdateGroupValidation.class)
	@Max(value = 0, groups = OnCreateGroupValidation.class)
	int id;
	
	@NotBlank
	String categoryName;
	
	
	public CategoryDto() {
		
	}
	
	public CategoryDto( int id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
