package com.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dao.ToolsAndTechnologiesDao;
import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.entity.Categories;
import com.portfolio.entity.ToolsAndTechnologies;

@Service
public class ToolsAndTechnologiesServiceImpl implements ToolsAndTechnologiesService{
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ToolsAndTechnologiesDao toolsAndTechnologiesDao;
	
	

	@Override
	public ToolsAndTechnologies addToolsAndTechnologies(ToolsAndTechnologiesDto toolsAndTechnologiesDto) {
		
		System.out.println(toolsAndTechnologiesDao.getToolsAndTechnologiesById(1));
		
//		ToolsAndTechnologies toolsAndTechnologies  = new ToolsAndTechnologies();
//		Categories category = categoryService.findCategoryById(toolsAndTechnologiesDto.getCategoryId());
//		
//		toolsAndTechnologies.setName(toolsAndTechnologiesDto.getName());
//		toolsAndTechnologies.setCategory(category);
//		return toolsAndTechnologiesDao.createToolsAndTechnologies(toolsAndTechnologies);
		return null;
		
		
	}
	

}
