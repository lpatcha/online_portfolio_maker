package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.ProjectsDto;
import com.portfolio.dto.StandardResponse;
import com.portfolio.dto.UserDetails;
import com.portfolio.entity.Projects;
import com.portfolio.entity.UserDetailsInfo;
import com.portfolio.services.ProjectsService;
import com.portfolio.services.UserService;
import com.portfolio.utils.ResponseMessages;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectsService projectsService;
	
	@PostMapping("create_userdetails")
	public ResponseEntity<StandardResponse> saveUserDetails(@RequestBody UserDetailsInfo userDetails) {
		
		StandardResponse<UserDetailsInfo> standardResponse = new StandardResponse<UserDetailsInfo>(userService.saveUserDetails(userDetails), ResponseMessages.SUCCESS_MESSAGE, ResponseMessages.SUCCESS_MESSAGE);
		
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	
	}
	
	//update user details
	@PutMapping("update_userdetails")
	public ResponseEntity<StandardResponse> updateUserDetails(@RequestBody UserDetails userDetails){
		System.out.println("inside update user details");
		StandardResponse<UserDetailsInfo> standardResponse = new StandardResponse<UserDetailsInfo>(userService.updateUserDetails(userDetails), ResponseMessages.UPDATE_MESSAGE, ResponseMessages.SUCCESS_MESSAGE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@PostMapping("create_projectinfo")
	public ResponseEntity<StandardResponse> saveUserDetails(@RequestBody ProjectsDto projectDto) {
		StandardResponse<ProjectsDto> standardResponse = new StandardResponse<ProjectsDto>(projectsService.saveUpdateProjectDetails(projectDto), ResponseMessages.INSERT_MESSAGE, ResponseMessages.INSERT_CODE);
		
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	
	}
	

//	project_name
//	client_name
//	location
//	role
//	start_date
//	end_date
//	user_id



	
}
