package com.portfolio.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.dao.MediaJpa;
import com.portfolio.dao.UserDao;
import com.portfolio.dto.SocialMediaDto;
import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.entity.Media;
import com.portfolio.entity.Projects;
import com.portfolio.entity.SocialMedia;
import com.portfolio.dto.CategoryDto;
import com.portfolio.dto.EducationDto;
import com.portfolio.dto.ProjectsDto;
import com.portfolio.dto.PublicUserDto;
import com.portfolio.dto.UserDetailsDto;
import com.portfolio.dto.UserToolsAndTechnologiesDto;
import com.portfolio.entity.Education;
import com.portfolio.entity.User;
import com.portfolio.entity.UserDetailsInfo;
import com.portfolio.entity.UserToolsAndTechnologies;
import com.portfolio.exceptionHandling.NotFoundException;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

@Service
public class UserDetailsServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Autowired
	MediaJpa mediaJpa;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails) {
		return userDao.saveUserDetails(userDetails);
		
	}
	
	@Override
	@Transactional
	public UserDetailsDto updateUserDetails(UserDetailsDto userDetails) throws NotFoundException {
		UserDetailsInfo userDetailsInfo = new UserDetailsInfo();
		
		User user  = userDao.findUserById(userDetails.getUserId());
		if(user == null)
			throw new NotFoundException("User with userId: "+ userDetails.getUserId() + " is not found");
		
		
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
		userDao.updateUserDetails(userDetailsInfo);
		
		return userDetails;
		
	}
	
	

	@Override
	@Transactional
	public EducationDto createUpdateEducation(EducationDto educationDto, String type) throws NotFoundException {
		
		Education education = new Education();
		if(type == "UPDATE")
		{
			if(userDao.findEducationById(educationDto.getId()) == null)
				throw new NotFoundException("Education with Education is: "+ educationDto.getId() + " is not found");
			
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
		if(user == null)
		  throw new NotFoundException("User with userId: "+ educationDto.getUserId() + " is not found");
		education.setUser(user);
		userDao.createEducation(education);
		educationDto.setId(education.getId());
		return educationDto;
		
	}
	
	@Override
	@Transactional
	public int deleteEducation(long id) {
		return userDao.deleteEducationById(id);
	}



	@Override
	public SocialMediaDto createSocialMedia(SocialMediaDto socialMediaDto) throws NotFoundException {
		SocialMedia socialMedia = new SocialMedia();
		socialMedia.setLink(socialMediaDto.getLink());
		User user  = userDao.findUserById(socialMediaDto.getUserId());
		if(user == null) {
			throw new NotFoundException("User with userid: " + socialMediaDto.getUserId() + "");
		}
		socialMedia.setUser(user);
		Media media = userDao.findMediaById(socialMediaDto.getMediaId());
		if(media == null) {
			throw new NotFoundException("media not found");
			
		}
		socialMedia.setMedia(media);
		socialMedia.setId(socialMediaDto.getId());
		SocialMedia newSocialMedia = userDao.createSocialMedia(socialMedia);
		socialMediaDto.setId(newSocialMedia.getId());
		return socialMediaDto;
	}
	
	@Override
	@Transactional
	public void deleteSocialMedia(int id) {
		mediaJpa.deleteById(id);
		
		
	}
	
	
	



	@Override
	@Transactional()
	public PublicUserDto getUserDetailsPublic(int id) {
		
		User user  = userDao.findUserById(id);
		UserDetailsInfo userDetails = userDao.findUserDetailsByUser(user);
		
		List<Education> education = user.getEducation();
		
		List<Projects> projects = user.getProjects();
		
		List<SocialMedia> socialMedia = user.getSocialMedia();
		
		List<UserToolsAndTechnologies> userToolsAndTechnologies = user.getUserToolsAndTechnologies();
		
//		UserDetailsDto userDetails = user.get
		
					//construct Dto
		PublicUserDto publicUserDto = new PublicUserDto();
		
		UserDetailsDto userDetailsDto = modelMapper.map(userDetails, UserDetailsDto.class);
		
		publicUserDto= modelMapper.map(user, PublicUserDto.class);
		
		publicUserDto.setUserDetailsDto(userDetailsDto);
		
		List<EducationDto> educationDtos = new ArrayList<EducationDto>();
		for(int i=0; i<education.size(); i++) {
			EducationDto educationDto = modelMapper.map(education.get(i), EducationDto.class);
			educationDtos.add(educationDto);
			
		}
		publicUserDto.setEducationDto(educationDtos);
		
		List<ProjectsDto> projectDtos = new ArrayList<ProjectsDto>();
		for(int i=0; i<projects.size(); i++) {
			ProjectsDto projectDto = modelMapper.map(projects.get(i), ProjectsDto.class);
			projectDtos.add(projectDto);
		}
		publicUserDto.setProjectDto(projectDtos);
		
		List<SocialMediaDto> socialMediaDtos = new ArrayList<SocialMediaDto>();
		for(int i=0; i<socialMedia.size(); i++) {
			SocialMediaDto socialMediaDto = modelMapper.map(socialMedia.get(i), SocialMediaDto.class);
			socialMediaDtos.add(socialMediaDto);

		}
		publicUserDto.setSocialMediaDto(socialMediaDtos);
		
		List<UserToolsAndTechnologiesDto> userToolsAndTechnologiesDtos = new ArrayList<UserToolsAndTechnologiesDto>();
		for(int i=0; i<userToolsAndTechnologies.size(); i++) {
			UserToolsAndTechnologiesDto userToolsAndTechnologiesDto = modelMapper.map(userToolsAndTechnologies.get(i), UserToolsAndTechnologiesDto.class);
			ToolsAndTechnologiesDto toolsAndTechnologiesDto = modelMapper.map(userToolsAndTechnologies.get(i).getToolsAndTechnologies(), ToolsAndTechnologiesDto.class);
			CategoryDto categoryDto = modelMapper.map(userToolsAndTechnologies.get(i).getToolsAndTechnologies().getCategory(), CategoryDto.class);
			toolsAndTechnologiesDto.setCategory(categoryDto);
			userToolsAndTechnologiesDto.setToolsAndTechnology(toolsAndTechnologiesDto);
			
			userToolsAndTechnologiesDtos.add(userToolsAndTechnologiesDto);
		}
		publicUserDto.setUserToolsAndTechnologiesDto(userToolsAndTechnologiesDtos);
		

		return publicUserDto;
	}

}
