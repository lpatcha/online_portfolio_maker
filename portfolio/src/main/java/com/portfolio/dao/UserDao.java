package com.portfolio.dao;
import com.portfolio.entity.Media;
import com.portfolio.entity.SocialMedia;
import com.portfolio.entity.Education;
import com.portfolio.entity.User;
import com.portfolio.entity.UserDetailsInfo;
import com.portfolio.exceptionHandling.InvalidJwtException;

public interface UserDao {
	
	UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails);
	User findUserByUserName(String userName);
	User saveUser(User data, UserDetailsInfo userDetailsInfo) throws InvalidJwtException;
	User findUserById(int id);
	UserDetailsInfo updateUserDetails(UserDetailsInfo userDetailsInfo);
	Media findMediaById(int id);
	SocialMedia createSocialMedia(SocialMedia socialMedia);
	Education createEducation(Education education);
	int deleteEducationById(long id);
	User updateUser(User user);
	Education findEducationById(int id);
	User publicFindUserById(int id);
	UserDetailsInfo findUserDetailsByUser(User user);
	
	
}
