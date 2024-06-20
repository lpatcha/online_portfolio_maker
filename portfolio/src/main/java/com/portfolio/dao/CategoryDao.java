package com.portfolio.dao;

import com.portfolio.entity.Categories;

public interface CategoryDao {
	Categories findCategoryById(int id);
	Categories createCategory(Categories category);
	
}
