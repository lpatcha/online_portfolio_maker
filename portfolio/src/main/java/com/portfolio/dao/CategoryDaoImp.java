package com.portfolio.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Categories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoryDaoImp implements CategoryDao {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public CategoryDaoImp(EntityManager entityManager){
		this.entityManager  = entityManager;
	}

	@Override
	@Transactional
	public Categories findById(int id) {
		
		
		TypedQuery<Categories> query = entityManager.createQuery(" select c from Categories c where id = :id", Categories.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
		
		
	}

	
}
