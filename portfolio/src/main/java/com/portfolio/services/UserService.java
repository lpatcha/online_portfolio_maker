package com.portfolio.services;
import com.portfolio.dto.SocialMediaDto;
import com.portfolio.dto.UserDetailsDto;
import com.portfolio.entity.SocialMedia;
import com.portfolio.dto.EducationDto;
import com.portfolio.dto.PublicUserDto;
import com.portfolio.entity.UserDetailsInfo;
import com.portfolio.exceptionHandling.NotFoundException;

public interface UserService {
	UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails);
	UserDetailsDto updateUserDetails(UserDetailsDto userDetails) throws NotFoundException;
	

	SocialMediaDto createSocialMedia(SocialMediaDto socialMediaDto) throws NotFoundException;
	void deleteSocialMedia(int id);
	EducationDto createUpdateEducation(EducationDto educationDto, String type) throws NotFoundException;
	
	int deleteEducation(long id);
	PublicUserDto getUserDetailsPublic(int id);
	
}
