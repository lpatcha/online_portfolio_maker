package com.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dao.MediaJpa;
import com.portfolio.dao.UserDao;
import com.portfolio.dto.SocialMediaDto;
import com.portfolio.dto.UserDetails;
import com.portfolio.entity.Media;
import com.portfolio.entity.SocialMedia;
import com.portfolio.entity.User;
import com.portfolio.entity.UserDetailsInfo;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Autowired
	MediaJpa mediaJpa;
	
	@Override
	public UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails) {
		return userDao.saveUserDetails(userDetails);
		
	}
	
	@Override
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
	public SocialMedia createSocialMedia(SocialMediaDto socialMediaDto) {
		SocialMedia socialMedia = new SocialMedia();
		socialMedia.setLink(socialMediaDto.getLink());
		User user  = userDao.findUserById(socialMediaDto.getUserId());
		socialMedia.setUser(user);
		Media media = userDao.findMediaById(socialMediaDto.getMediaId());
		socialMedia.setMedia(media);
		socialMedia.setId(socialMediaDto.getId());
		
		return userDao.createSocialMedia(socialMedia);
	}
	
	@Override
	@Transactional
	public void deleteSocialMedia(int id) {
		mediaJpa.deleteById(id);
		
	}

}
