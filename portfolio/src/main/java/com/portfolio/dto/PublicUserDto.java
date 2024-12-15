package com.portfolio.dto;

import java.util.List;

public class PublicUserDto {
	int id;
	List<EducationDto> educationDto;
	List<ProjectsDto> projectDto;
	List<SocialMediaDto> socialMediaDto;
	List<UserToolsAndTechnologiesDto> userToolsAndTechnologiesDto;
	UserDetailsDto userDetailsDto;
	
	
	public List<UserToolsAndTechnologiesDto> getUserToolsAndTechnologiesDto() {
		return userToolsAndTechnologiesDto;
	}
	public void setUserToolsAndTechnologiesDto(List<UserToolsAndTechnologiesDto> userToolsAndTechnologiesDto) {
		this.userToolsAndTechnologiesDto = userToolsAndTechnologiesDto;
	}
	public UserDetailsDto getUserDetailsDto() {
		return userDetailsDto;
	}
	public void setUserDetailsDto(UserDetailsDto userDetailsDto) {
		this.userDetailsDto = userDetailsDto;
	}
	public List<SocialMediaDto> getSocialMediaDto() {
		return socialMediaDto;
	}
	public void setSocialMediaDto(List<SocialMediaDto> socialMediaDto) {
		this.socialMediaDto = socialMediaDto;
	}
	public List<ProjectsDto> getProjectDto() {
		return projectDto;
	}
	public void setProjectDto(List<ProjectsDto> projectDto) {
		this.projectDto = projectDto;
	}
	public List<EducationDto> getEducationDto() {
		return educationDto;
	}
	public void setEducationDto(List<EducationDto> educationDto) {
		this.educationDto = educationDto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
}
