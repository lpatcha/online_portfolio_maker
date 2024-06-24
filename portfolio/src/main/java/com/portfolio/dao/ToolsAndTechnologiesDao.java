package com.portfolio.dao;

import com.portfolio.entity.ToolsAndTechnologies;
import com.portfolio.entity.UserToolsAndTechnologies;

public interface ToolsAndTechnologiesDao {
	
	ToolsAndTechnologies createToolsAndTechnologies(ToolsAndTechnologies toolsAndTechnologies);
	
	ToolsAndTechnologies getToolsAndTechnologiesById(int id);
	
	UserToolsAndTechnologies createUserToolsAndTechnologies(UserToolsAndTechnologies userToolsAndTechnologies);
	
	int deleteUserToolsAndTechnologies(long id);
	


}
