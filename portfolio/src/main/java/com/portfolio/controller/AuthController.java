package com.portfolio.controller;
import com.portfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.config.TokenProvider;
import com.portfolio.dto.JwtDto;
import com.portfolio.dto.SignInDto;
import com.portfolio.dto.SignUpDto;
import com.portfolio.dto.StandardResponse;
import com.portfolio.exceptionHandling.InvalidJwtException;
import com.portfolio.services.AuthService;
import com.portfolio.utils.ResponseMessages;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	  private AuthenticationManager authenticationManager;
	
	@Autowired
	  private AuthService service;
	
	 @Autowired
	  private TokenProvider tokenService;
	 
	 
	 @PostMapping("/signup")
	  public ResponseEntity<StandardResponse> signUp(@RequestBody SignUpDto data) throws InvalidJwtException  {
		/**
		 * 
		 * release 1
		 * TO - DO 
		 * 1. perform validation
		 * 2. proper error handling 
		 * 3. any suggestions are highly appreciated
		 */
		 
	    service.signUp(data);
	    StandardResponse<?> standardResponse = new StandardResponse("User Registered Sucessfully", ResponseMessages.INSERT_CODE);
	    
	    return new ResponseEntity<StandardResponse>(standardResponse, HttpStatus.CREATED);
	  }
	 
	 @PostMapping("/signin")
	  public ResponseEntity<StandardResponse<JwtDto>> signIn(@RequestBody SignInDto data) {
		
		 var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUserName(), data.getPassword());
		 
		 authenticationManager.authenticate(usernamePassword);
		
	    String accessToken = tokenService.generateAccessToken(data.getUserName());
	    
	    
	    StandardResponse<JwtDto> standardResponse = new StandardResponse<JwtDto>(new JwtDto(accessToken, data.getUserName()),"User signedIn Sucessfully", ResponseMessages.SUCCESS);
    
	    return new ResponseEntity<StandardResponse<JwtDto>>(standardResponse, HttpStatus.OK);
	
	    
	  }

	
}
