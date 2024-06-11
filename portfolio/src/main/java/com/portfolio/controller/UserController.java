package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.dto.StandardResponse;
import com.portfolio.entity.UserDetails;
import com.portfolio.services.UserService;
import com.portfolio.utils.ResponseMessages;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("create_userdetails")
	public ResponseEntity<StandardResponse> saveUserDetails(@RequestBody UserDetails userDetails) {
		StandardResponse<UserDetails> standardResponse = new StandardResponse<UserDetails>(userService.saveUserDetails(userDetails), ResponseMessages.SUCCESS_MESSAGE, ResponseMessages.SUCCESS_MESSAGE);
		
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	
	}
	
	
	
}
