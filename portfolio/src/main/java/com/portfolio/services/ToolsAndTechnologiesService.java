package com.portfolio.services;

import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.dto.UserToolsAndTechnologiesDto;


public interface ToolsAndTechnologiesService{

	ToolsAndTechnologiesDto addToolsAndTechnologies(ToolsAndTechnologiesDto toolsAndTechnologiesDto);
	
	ToolsAndTechnologiesDto updateToolsAndTechologies(ToolsAndTechnologiesDto toolsAndTechnologiesDto);
	
	UserToolsAndTechnologiesDto createAndUpdateUserToolsAndTechnologies(UserToolsAndTechnologiesDto userToolsAndTechnologiesDto, String type);
	
	int deleteUserToolsAndTechnologies(long id);
	
	
}
