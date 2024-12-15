package com.portfolio.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.dao.ProjectsDao;
import com.portfolio.dao.RolesAndResponsibilitesDao;
import com.portfolio.dao.UserDao;
import com.portfolio.dto.ProjectsDto;
import com.portfolio.dto.RolesAndResponsibilitesDto;
import com.portfolio.entity.Projects;
import com.portfolio.entity.RolesAndResponsibilites;
import com.portfolio.entity.User;
import com.portfolio.exceptionHandling.NotFoundException;

@Service
public class ProjectsServiceImpl implements ProjectsService {

		
	
	@Autowired 
	UserDao userDao;
	
	@Autowired
	ProjectsDao projectDao;

	@Autowired
	RolesAndResponsibilitesDao rolesAndResponsibilitesDao;
	
	@Override
	@Transactional
	public ProjectsDto saveUpdateProjectDetails(ProjectsDto projectDto) throws NotFoundException {
		
		// TODO Auto-generated method stub
		User user = userDao.findUserById(projectDto.getUserId());
		if(user == null) {
			throw new NotFoundException("User with user id: " + projectDto.getUserId() + " cannot be found");
			
		}
		Projects project= new Projects();
		project.setId(projectDto.getId());
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


	@Override
	@Transactional
	public RolesAndResponsibilitesDto createAndUpdateRoleAndResponsibility(
			RolesAndResponsibilitesDto rolesAndResponsibilitesDto) throws NotFoundException {
		// TODO Auto-generated method stub
		
		int id = rolesAndResponsibilitesDto.getId();
		//check if a project exists or not
		int projectId = rolesAndResponsibilitesDto.getProjectId();
		Projects project = projectDao.findByProjectID(projectId);
		if(project == null)
			throw new NotFoundException("Project with project id: " + projectId + " cannot be found");
		RolesAndResponsibilites rolesAndResponsibilites = new RolesAndResponsibilites();
		rolesAndResponsibilites.setDescription(rolesAndResponsibilitesDto.getDescription());
		rolesAndResponsibilites.setProject(project);
		if(id == 0) {
			//create new roles and responsibilites
			rolesAndResponsibilites = rolesAndResponsibilitesDao.createRolesAndResponsibilites(rolesAndResponsibilites);
			rolesAndResponsibilitesDto.setId(rolesAndResponsibilites.getId());
			
		}
		else {
			//update existing one
			rolesAndResponsibilites.setId(id);
			rolesAndResponsibilitesDao.createRolesAndResponsibilites(rolesAndResponsibilites);
			
		}
		
		return rolesAndResponsibilitesDto;
	}
}
