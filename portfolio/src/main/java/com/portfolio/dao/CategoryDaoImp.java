package com.portfolio.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Categories;

import jakarta.transaction.Transactional;



@Repository
public class CategoryDaoImp implements CategoryDao{
	
	
	@Autowired
	CategoryDaoJpa categoryDaoJpa;
	
	
	
	public CategoryDaoImp(){
		
	}

	

	@Override
	public Categories findCategoryById(int id) {
		return categoryDaoJpa.findById(id);
		
	}



	@Override
	@Transactional
	public Categories createCategory(Categories category) {
		return categoryDaoJpa.save(category);
	}
	
	
	
}
