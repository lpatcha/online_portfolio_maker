package com.portfolio.services;


import com.portfolio.dto.ProjectsDto;
import com.portfolio.dto.RolesAndResponsibilitesDto;
import com.portfolio.exceptionHandling.NotFoundException;

public interface ProjectsService {
	


	ProjectsDto saveUpdateProjectDetails(ProjectsDto projectDto) throws NotFoundException;
	RolesAndResponsibilitesDto createAndUpdateRoleAndResponsibility(RolesAndResponsibilitesDto rolesAndResponsibilitesDto) throws NotFoundException;

}
