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
import com.portfolio.exceptionHandling.NotFoundException;

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
	@Transactional
	public ToolsAndTechnologiesDto addToolsAndTechnologies(ToolsAndTechnologiesDto toolsAndTechnologiesDto) {
	
		System.out.println("called");
		ToolsAndTechnologies toolsAndTechnologies  = new ToolsAndTechnologies();
		Categories category = categoryService.findCategoryById(toolsAndTechnologiesDto.getCategoryId());
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setCategoryName(category.getCategoryName());
		
		if(toolsAndTechnologiesDto.getId() != 0)
			toolsAndTechnologies.setId(toolsAndTechnologiesDto.getId());
		
		
		toolsAndTechnologies.setName(toolsAndTechnologiesDto.getName());
		toolsAndTechnologies.setCategory(category);
		toolsAndTechnologiesDao.createToolsAndTechnologies(toolsAndTechnologies);
		
		toolsAndTechnologiesDto.setId(toolsAndTechnologies.getId());
		toolsAndTechnologiesDto.setCategory(categoryDto);
		
		return toolsAndTechnologiesDto;
	
	}




	@Override
	public UserToolsAndTechnologiesDto createAndUpdateUserToolsAndTechnologies(
			UserToolsAndTechnologiesDto userToolsAndTechnologiesDto, String type) throws NotFoundException {
		UserToolsAndTechnologies userToolsAndTechnologies = new UserToolsAndTechnologies();
		userToolsAndTechnologies.setDescription(userToolsAndTechnologiesDto.getDescription());
		userToolsAndTechnologies.setProficiencyRating(userToolsAndTechnologiesDto.getProficiencyRating());
		if(type == "UPDATE")
		{
			if(toolsAndTechnologiesDao.getToolsAndTechnologiesById(userToolsAndTechnologiesDto.getToolId()) == null)
				throw new NotFoundException("Tool with toolid: "+ userToolsAndTechnologiesDto.getToolId() + " is not found");
			
			userToolsAndTechnologies.setId(userToolsAndTechnologiesDto.getId());
		}
		User user = userDao.findUserById(userToolsAndTechnologiesDto.getUserId());
		if(user == null)
			throw new NotFoundException("User with userId: "+ userToolsAndTechnologiesDto.getUserId() + " is not found");
		
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
