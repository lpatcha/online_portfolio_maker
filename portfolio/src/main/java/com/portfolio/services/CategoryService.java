package com.portfolio.services;

import com.portfolio.dto.CategoryDto;
import com.portfolio.entity.Categories;

public interface CategoryService {
	
	Categories findCategoryById(int id);
	
	Categories createCategory(CategoryDto categoryDto);
	
	Categories updateCategory(CategoryDto categoryDto);
	
	
}
