package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.Education;


public interface EducationJpa  extends JpaRepository<Education, Long>{
    Education findEducationById(int id);
}
