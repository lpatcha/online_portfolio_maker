package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.ToolsAndTechnologies;


@Repository
public class ToolsAndTechnologiesDaoImpl implements ToolsAndTechnologiesDao{
	
	@Autowired 
	ToolsAndTechnologiesDaoJpa toolsAndTechnologiesJpa;
	

	@Override
	public ToolsAndTechnologies createToolsAndTechnologies(ToolsAndTechnologies toolsAndTechnologies) {
		
		return toolsAndTechnologiesJpa.save(toolsAndTechnologies);
		
	}


	@Override
	public ToolsAndTechnologies getToolsAndTechnologiesById(int id) {
		
		return toolsAndTechnologiesJpa.findById(id);
	}
	
	
	

}
