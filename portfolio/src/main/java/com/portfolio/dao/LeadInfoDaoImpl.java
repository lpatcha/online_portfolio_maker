package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.LeadInfo;


@Repository
public class LeadInfoDaoImpl implements LeadInfoDao{
	
	
	@Autowired
	LeadInfoJpa leadInfoJpa;

	@Override
	public LeadInfo SaveLeadInfo(LeadInfo leadInfo) {
		
		return leadInfoJpa.save(leadInfo);
		
	}

}
