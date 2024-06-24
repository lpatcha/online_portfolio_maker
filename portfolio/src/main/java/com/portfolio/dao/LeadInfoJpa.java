package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.LeadInfo;

public interface LeadInfoJpa  extends  JpaRepository<LeadInfo, Long>  {
	
	

}
