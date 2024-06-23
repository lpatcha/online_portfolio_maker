package com.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dao.LeadInfoDao;
import com.portfolio.dao.UserDao;
import com.portfolio.dto.LeadInfoDto;
import com.portfolio.entity.LeadInfo;
import com.portfolio.entity.User;


@Service
public class LeadInfoServiceImpl implements LeadInfoService {
	
	@Autowired
	LeadInfoDao leadInfoDao;
	
	@Autowired
	UserDao userDao;

	@Override
	public LeadInfoDto saveLeadInfoMsg(LeadInfoDto leadInfoDto) {
		
		
		User user=userDao.findUserById( leadInfoDto.getUserId());
		
		LeadInfo leadInfo=new LeadInfo();
		
		leadInfo.setEmail(leadInfoDto.getEmail());
		leadInfo.setFirstName(leadInfoDto.getFirstName());
		leadInfo.setLastName(leadInfoDto.getLastName());
		leadInfo.setMessage(leadInfoDto.getMessage());
		leadInfo.setPhoneNo(leadInfoDto.getPhoneNo());
		leadInfo.setUser(user);
		
		
		leadInfoDao.SaveLeadInfo(leadInfo);
		
		
		
		
		return leadInfoDto;
	}
	
	

}
