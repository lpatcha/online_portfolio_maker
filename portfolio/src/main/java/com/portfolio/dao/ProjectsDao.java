package com.portfolio.dao;

import com.portfolio.entity.Projects;

public interface ProjectsDao {
	
	Projects findByProjectID(int id);
	Projects SaveProject(Projects project);
	

}
