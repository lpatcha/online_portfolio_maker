package com.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dao.CategoryDao;
import com.portfolio.dao.ToolsAndTechnologiesDao;
import com.portfolio.dao.UserDao;
import com.portfolio.dto.CategoryDto;
import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.dto.UserToolsAndTechnologiesDto;
import com.portfolio.entity.Categories;
import com.portfolio.entity.ToolsAndTechnologies;
import com.portfolio.entity.User;
import com.portfolio.entity.UserToolsAndTechnologies;

import jakarta.transaction.Transactional;

@Service
public class ToolsAndTechnologiesServiceImpl implements ToolsAndTechnologiesService{
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ToolsAndTechnologiesDao toolsAndTechnologiesDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired UserDao userDao;
	

	@Override
	public ToolsAndTechnologiesDto addToolsAndTechnologies(ToolsAndTechnologiesDto toolsAndTechnologiesDto) {
	
		
		ToolsAndTechnologies toolsAndTechnologies  = new ToolsAndTechnologies();
		Categories category = categoryService.findCategoryById(toolsAndTechnologiesDto.getCategoryId());
		
		toolsAndTechnologies.setName(toolsAndTechnologiesDto.getName());
		toolsAndTechnologies.setCategory(category);
		toolsAndTechnologiesDao.createToolsAndTechnologies(toolsAndTechnologies);
		toolsAndTechnologiesDto.setId(toolsAndTechnologies.getId());
		return toolsAndTechnologiesDto;
	
	}



	@Override
	public ToolsAndTechnologiesDto updateToolsAndTechologies(ToolsAndTechnologiesDto toolsAndTechnologiesDto) {
		
		ToolsAndTechnologies toolsAndTechnologies  = new ToolsAndTechnologies();
		Categories category  = categoryService.findCategoryById(toolsAndTechnologiesDto.getCategoryId());
		toolsAndTechnologies.setName(toolsAndTechnologiesDto.getName());
		toolsAndTechnologies.setId(toolsAndTechnologiesDto.getId());
		toolsAndTechnologies.setCategory(category);
		toolsAndTechnologiesDao.createToolsAndTechnologies(toolsAndTechnologies);
		return toolsAndTechnologiesDto;
	}



	@Override
	public UserToolsAndTechnologiesDto createAndUpdateUserToolsAndTechnologies(
			UserToolsAndTechnologiesDto userToolsAndTechnologiesDto, String type) {
		UserToolsAndTechnologies userToolsAndTechnologies = new UserToolsAndTechnologies();
		userToolsAndTechnologies.setDescription(userToolsAndTechnologiesDto.getDescription());
		userToolsAndTechnologies.setProficiencyRating(userToolsAndTechnologiesDto.getProficiencyRating());
		if(type == "UPDATE")
		{
			userToolsAndTechnologies.setId(userToolsAndTechnologiesDto.getId());
		}
		
		User user = userDao.findUserById(userToolsAndTechnologiesDto.getUserId());
		
		ToolsAndTechnologies toolsAndTechnologies = toolsAndTechnologiesDao.getToolsAndTechnologiesById(userToolsAndTechnologiesDto.getToolId());
		userToolsAndTechnologies.setToolsAndTechnologies(toolsAndTechnologies);
		userToolsAndTechnologies.setUser(user);
		userToolsAndTechnologies = toolsAndTechnologiesDao.createUserToolsAndTechnologies(userToolsAndTechnologies);
		userToolsAndTechnologiesDto.setId(userToolsAndTechnologies.getId());
		return userToolsAndTechnologiesDto;
	}



	@Override
	@Transactional
	public int deleteUserToolsAndTechnologies(long id) {
		return toolsAndTechnologiesDao.deleteUserToolsAndTechnologies(id);
		
	}


	

}
