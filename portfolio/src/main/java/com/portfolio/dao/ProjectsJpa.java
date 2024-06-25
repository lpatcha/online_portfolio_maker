package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.Projects;

public interface ProjectsJpa extends JpaRepository<Projects, Long> {
	Projects findById(int id);

}
