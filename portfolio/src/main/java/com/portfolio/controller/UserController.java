package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.SocialMediaDto;
import com.portfolio.dto.StandardResponse;
import com.portfolio.dto.UserDetails;
import com.portfolio.entity.SocialMedia;
import com.portfolio.entity.UserDetailsInfo;
import com.portfolio.services.UserService;
import com.portfolio.utils.ResponseMessages;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	
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
	
	@PostMapping("create_social_media")
	public ResponseEntity<StandardResponse> createSocialMedia(@RequestBody SocialMediaDto socialMediaDto){
		StandardResponse<SocialMedia> standardResponse = new StandardResponse<SocialMedia>(userService.createSocialMedia(socialMediaDto), ResponseMessages.INSERT_MESSAGE, ResponseMessages.INSERT_CODE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("update_social_media")
	public ResponseEntity<StandardResponse> updateSocialMedia(@RequestBody SocialMediaDto socialMediaDto){
		StandardResponse<SocialMedia> standardResponse = new StandardResponse<SocialMedia>(userService.createSocialMedia(socialMediaDto), ResponseMessages.UPDATE_MESSAGE, ResponseMessages.SUCCESS);
		return new ResponseEntity<>(standardResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("delete_social_media")
	public ResponseEntity<StandardResponse> deleteSocialMedia(@RequestParam int id ){
		userService.deleteSocialMedia(id);
		StandardResponse standardResponse = new StandardResponse(ResponseMessages.DELETE_MESSAGE, ResponseMessages.DELETE);
		
		return new ResponseEntity<>(standardResponse, HttpStatus.OK);
	}
}
