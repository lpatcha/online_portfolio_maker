package com.portfolio.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.portfolio.dao.CategoryDao;
import com.portfolio.entity.Categories;


@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDaoImp;
	
	
	@Override
	public Categories findCategoryById(int id) {
		return categoryDaoImp.findById(id);
		
	}

}
