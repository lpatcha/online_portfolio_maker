package com.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.dao.ProjectsDao;
import com.portfolio.dao.UserDao;
import com.portfolio.dto.ProjectsDto;
import com.portfolio.entity.Projects;
import com.portfolio.entity.User;

@Service
public class ProjectsServiceImpl implements ProjectsService {

		
	
	@Autowired 
	UserDao userDao;
	
	@Autowired
	ProjectsDao projectDao;


	@Override
	@Transactional
	public ProjectsDto saveUpdateProjectDetails(ProjectsDto projectDto) {
		// TODO Auto-generated method stub
		User user = userDao.findUserById(projectDto.getUserId());
		Projects project= new Projects();
		
		
		
		project.setClientName(projectDto.getClientName());
		project.setLocation(projectDto.getLocation());
		project.setProjectName(projectDto.getProjectName());
		project.setRole(projectDto.getRole());
		project.setEndDate(projectDto.getEndDate());
		project.setStartDate(projectDto.getStartDate());
		project.setUser(user);
		
		projectDto.setId( projectDao.SaveProject(project).getId());
		
		return projectDto;
		
		 
	}
	

}
