package com.portfolio.services;

import com.portfolio.dto.SocialMediaDto;
import com.portfolio.dto.UserDetails;
import com.portfolio.entity.SocialMedia;
import com.portfolio.entity.UserDetailsInfo;

public interface UserService {

	
	UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails);
	
	UserDetailsInfo updateUserDetails(UserDetails userDetails);
	
	SocialMedia createSocialMedia(SocialMediaDto socialMediaDto);

	void deleteSocialMedia(int id);
	
}
