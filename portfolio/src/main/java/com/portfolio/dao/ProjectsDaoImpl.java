package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Projects;


@Repository
public class ProjectsDaoImpl implements ProjectsDao {
	
	
	@Autowired
	ProjectsJpa projectsJpa;

	@Override

	public Projects SaveProject(Projects project) {
		
		return projectsJpa.save(project);
		
	}


	@Override
	public Projects findByProjectID(int id) {
		
		return projectsJpa.findById(id);
	}

}
