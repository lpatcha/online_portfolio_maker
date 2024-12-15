package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.entity.ToolsAndTechnologies;
import com.portfolio.entity.UserToolsAndTechnologies;

import jakarta.transaction.Transactional;


@Repository
public class ToolsAndTechnologiesDaoImpl implements ToolsAndTechnologiesDao{
	
	@Autowired 
	ToolsAndTechnologiesDaoJpa toolsAndTechnologiesJpa;
	
	@Autowired
	UserToolsAndTechnologiesDaoJpa userToolsAndTechnologiesDaoJpa;
	
	

	@Override
	public ToolsAndTechnologies createToolsAndTechnologies(ToolsAndTechnologies toolsAndTechnologies) {
		
		return toolsAndTechnologiesJpa.save(toolsAndTechnologies);
		
	}


	@Override
	public ToolsAndTechnologies getToolsAndTechnologiesById(int id) {
		
		return toolsAndTechnologiesJpa.findById(id);
	}
	


	@Override
	@Transactional
	public UserToolsAndTechnologies createUserToolsAndTechnologies(UserToolsAndTechnologies userToolsAndTechnologies) {
		
		return userToolsAndTechnologiesDaoJpa.save(userToolsAndTechnologies);
	}


	@Override
	public int deleteUserToolsAndTechnologies(long id) {
		userToolsAndTechnologiesDaoJpa.deleteById(id);
		return 1;
	}


	

}
