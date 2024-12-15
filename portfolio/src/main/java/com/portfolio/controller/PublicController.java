package com.portfolio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.dto.PublicUserDto;
import com.portfolio.dto.StandardResponse;
import com.portfolio.services.UserService;
import com.portfolio.utils.ResponseMessages;

import jakarta.validation.constraints.Min;



@RestController
@RequestMapping("/api/public")
@Validated
public class PublicController {

@Autowired
UserService userService;

	
@GetMapping("/{userId}")
public ResponseEntity<StandardResponse<PublicUserDto>> getUserInfo(@PathVariable @Min(value = 1, message = "user id cannot be null") int userId) {
	
	StandardResponse<PublicUserDto> standardResponse = new StandardResponse<>(userService.getUserDetailsPublic(userId),ResponseMessages.SUCCESS_MESSAGE, ResponseMessages.SUCCESS);
	return new ResponseEntity<StandardResponse<PublicUserDto>>(standardResponse, HttpStatus.ACCEPTED);	
	
}

}
