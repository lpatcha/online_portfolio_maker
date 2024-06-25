package com.portfolio.services;

import com.portfolio.dto.SocialMediaDto;
import com.portfolio.dto.UserDetails;
import com.portfolio.entity.SocialMedia;

import com.portfolio.dto.EducationDto;
import com.portfolio.dto.UserDetails;

import com.portfolio.entity.UserDetailsInfo;

public interface UserService {
	UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails);
	UserDetailsInfo updateUserDetails(UserDetails userDetails);
	

	SocialMedia createSocialMedia(SocialMediaDto socialMediaDto);
	void deleteSocialMedia(int id);
	EducationDto createUpdateEducation(EducationDto educationDto, String type);
	
	int deleteEducation(long id);
	
}
