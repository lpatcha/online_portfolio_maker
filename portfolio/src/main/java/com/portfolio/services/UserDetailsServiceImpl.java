package com.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dao.UserDao;
import com.portfolio.dto.EducationDto;
import com.portfolio.dto.UserDetails;
import com.portfolio.entity.Education;
import com.portfolio.entity.User;
import com.portfolio.entity.UserDetailsInfo;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails) {
		return userDao.saveUserDetails(userDetails);
		
	}
	
	@Override
	@Transactional
	public UserDetailsInfo updateUserDetails(UserDetails userDetails) {
		UserDetailsInfo userDetailsInfo = new UserDetailsInfo();
		
		User user  = userDao.findUserById(userDetails.getUserId());
	
		userDetailsInfo.setAboutMe(userDetails.getAboutme());
		userDetailsInfo.setAddress(userDetails.getAddress());
		userDetailsInfo.setDateOfBirth(userDetails.getDateOfBirth());
		userDetailsInfo.setEmail(userDetails.getEmail());
		userDetailsInfo.setFirstName(userDetails.getFirstName());
		userDetailsInfo.setLastName(userDetails.getLastName());
		userDetailsInfo.setPhoneNo(userDetails.getPhoneNo());
		userDetailsInfo.setPhoto(userDetails.getPhoto());
		userDetailsInfo.setId(userDetails.getId());
		userDetailsInfo.setUser(user);
		
		return userDao.updateUserDetails(userDetailsInfo);
		
		
	}
	
	

	@Override
	@Transactional
	public EducationDto createUpdateEducation(EducationDto educationDto, String type) {
		
		Education education = new Education();
		if(type == "UPDATE")
		{
			education.setId(educationDto.getId());
		}
		education.setCgpa(educationDto.getCgpa());
		education.setDegree(educationDto.getDegree());
		education.setDescription(educationDto.getDescription());
		education.setEndDate(educationDto.getEndDate());
		education.setStartDate(educationDto.getStartDate());
		education.setInstitutionName(educationDto.getInstitutionName());
		education.setMaxCgpa(educationDto.getMaxCgpa());

		User user  = userDao.findUserById(educationDto.getUserId());
		education.setUser(user);
		Education education2 = userDao.createEducation(education);
		educationDto.setId(education.getId());
		return educationDto;
		
	}
	
	@Override
	@Transactional
	public int deleteEducation(long id) {
		return userDao.deleteEducationById(id);
	}



}
