package com.portfolio.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.portfolio.dao.CategoryDao;
import com.portfolio.dto.CategoryDto;
import com.portfolio.entity.Categories;
import com.portfolio.entity.ToolsAndTechnologies;


@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDaoImp;
	
	
	
	
	@Override
	public Categories findCategoryById(int id) {
		return categoryDaoImp.findCategoryById(id);
		
	}


	@Override
	public Categories createCategory(CategoryDto categoryDto) {
		
		Categories category = new Categories();
		category.setCategoryName(categoryDto.getCategoryName());
		category.setToolsAndTechnologies(new ArrayList<>());
		return categoryDaoImp.createCategory(category);
	}
	


	@Override
	public Categories updateCategory(CategoryDto categoryDto) {
		Categories category = new Categories();
		category.setCategoryName(categoryDto.getCategoryName());
		category.setId(categoryDto.getId());
		categoryDaoImp.createCategory(category);
		return category;
	}
	

}
