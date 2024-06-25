package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.ToolsAndTechnologies;

public interface ToolsAndTechnologiesDaoJpa extends JpaRepository<ToolsAndTechnologies, Integer> {
 
	ToolsAndTechnologies findById(int id);
}
