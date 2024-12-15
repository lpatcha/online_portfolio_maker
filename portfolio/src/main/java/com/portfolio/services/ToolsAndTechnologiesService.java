package com.portfolio.services;
import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.dto.UserToolsAndTechnologiesDto;
import com.portfolio.exceptionHandling.NotFoundException;


public interface ToolsAndTechnologiesService{

	ToolsAndTechnologiesDto addToolsAndTechnologies(ToolsAndTechnologiesDto toolsAndTechnologiesDto);
	
	
	UserToolsAndTechnologiesDto createAndUpdateUserToolsAndTechnologies(UserToolsAndTechnologiesDto userToolsAndTechnologiesDto, String type) throws NotFoundException;
	
	int deleteUserToolsAndTechnologies(long id);
	
}
