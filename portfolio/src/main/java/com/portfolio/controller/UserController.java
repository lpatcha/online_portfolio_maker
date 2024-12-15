package com.portfolio.controller;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.dto.SocialMediaDto;
import com.portfolio.dto.StandardResponse;
import com.portfolio.dto.UserDetailsDto;
import com.portfolio.entity.SocialMedia;
import com.portfolio.dto.LeadInfoDto;
import com.portfolio.dto.OnCreateGroupValidation;
import com.portfolio.dto.OnUpdateGroupValidation;
import com.portfolio.dto.ProjectsDto;
import com.portfolio.dto.CompareStringDto;
import com.portfolio.dto.DateRangeDto;
import com.portfolio.dto.EducationDto;

import com.portfolio.dto.ResetPasswordDto;
import com.portfolio.dto.RolesAndResponsibilitesDto;
import com.portfolio.entity.UserDetailsInfo;
import com.portfolio.services.LeadInfoService;
import com.portfolio.services.ProjectsService;
import com.portfolio.exceptionHandling.InvalidJwtException;
import com.portfolio.exceptionHandling.NotFoundException;
import com.portfolio.services.AuthService;
import com.portfolio.services.UserService;
import com.portfolio.utils.ResponseMessages;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectsService projectsService;
	
	@Autowired
	LeadInfoService leadInfoService;

	 @Autowired
	  private AuthService service;
	  

	
	
	@PostMapping("create_userdetails")
	public ResponseEntity<StandardResponse> saveUserDetails( @RequestBody @Valid UserDetailsInfo userDetails) {
		StandardResponse<UserDetailsInfo> standardResponse = new StandardResponse<UserDetailsInfo>(userService.saveUserDetails(userDetails), ResponseMessages.SUCCESS_MESSAGE, ResponseMessages.SUCCESS_MESSAGE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	}
	
	//update user details
	@PutMapping("update_userdetails")
	public ResponseEntity<StandardResponse> updateUserDetails(  @RequestBody @Valid UserDetailsDto userDetails, BindingResult bindingResult) throws NotFoundException{
		 if (bindingResult.hasErrors()) {
			 System.out.println("errors exists");
		 }
		
		StandardResponse<UserDetailsDto> standardResponse = new StandardResponse<UserDetailsDto>(userService.updateUserDetails(userDetails), ResponseMessages.UPDATE_MESSAGE, ResponseMessages.SUCCESS_MESSAGE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
		
	}

	
	//	Post mapping for saving the project details
	
	@PostMapping("create_projectinfo")
	@Validated(OnCreateGroupValidation.class)
	public ResponseEntity<StandardResponse> saveProjectDetails( @RequestBody @Valid ProjectsDto projectDto) throws NotFoundException{
		StandardResponse<ProjectsDto> standardResponse = new StandardResponse<ProjectsDto>(projectsService.saveUpdateProjectDetails(projectDto), ResponseMessages.INSERT_MESSAGE, ResponseMessages.INSERT_CODE);
		
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	
	}
	//	Put mapping for saving the project details
	@PutMapping("create_projectinfo")
	@Validated(OnUpdateGroupValidation.class)
	public ResponseEntity<StandardResponse> updateProjectDetails( @RequestBody @Valid ProjectsDto projectDto) throws NotFoundException{
		StandardResponse<ProjectsDto> standardResponse = new StandardResponse<ProjectsDto>(projectsService.saveUpdateProjectDetails(projectDto), ResponseMessages.INSERT_MESSAGE, ResponseMessages.INSERT_CODE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	}
	
	@PostMapping("create_roles_and_responsibilites")
	@Validated(OnCreateGroupValidation.class)
	public ResponseEntity<StandardResponse> createRolesAndResponsibilites( @RequestBody @Valid RolesAndResponsibilitesDto rolesAndResponsibilitesDto) throws NotFoundException{
		StandardResponse<RolesAndResponsibilitesDto> standardResponse = new StandardResponse<RolesAndResponsibilitesDto>(projectsService.createAndUpdateRoleAndResponsibility(rolesAndResponsibilitesDto), ResponseMessages.INSERT_MESSAGE, ResponseMessages.INSERT_CODE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	
	}
	
	@PutMapping("create_roles_and_responsibilites")
	@Validated(OnUpdateGroupValidation.class)
	public ResponseEntity<StandardResponse> updateRolesAndResponsibilites( @RequestBody @Valid RolesAndResponsibilitesDto rolesAndResponsibilitesDto) throws NotFoundException{
		StandardResponse<RolesAndResponsibilitesDto> standardResponse = new StandardResponse<RolesAndResponsibilitesDto>(projectsService.createAndUpdateRoleAndResponsibility(rolesAndResponsibilitesDto), ResponseMessages.UPDATE_MESSAGE, ResponseMessages.SUCCESS);
		
		return new ResponseEntity<>(standardResponse, HttpStatus.OK);
	}
	
	

	@PostMapping("create_social_media")
	@Validated(OnCreateGroupValidation.class)
	public ResponseEntity<StandardResponse> createSocialMedia(@RequestBody @Valid SocialMediaDto socialMediaDto) throws NotFoundException{
		StandardResponse<SocialMediaDto> standardResponse = new StandardResponse<SocialMediaDto>(userService.createSocialMedia(socialMediaDto), ResponseMessages.INSERT_MESSAGE, ResponseMessages.INSERT_CODE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("update_social_media")
	@Validated(OnUpdateGroupValidation.class)
	public ResponseEntity<StandardResponse> updateSocialMedia(@RequestBody @Valid SocialMediaDto socialMediaDto) throws NotFoundException{
		StandardResponse<SocialMediaDto> standardResponse = new StandardResponse<SocialMediaDto>(userService.createSocialMedia(socialMediaDto), ResponseMessages.UPDATE_MESSAGE, ResponseMessages.SUCCESS);
		return new ResponseEntity<>(standardResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("delete_social_media")
	public ResponseEntity<StandardResponse> deleteSocialMedia(@RequestParam int id ){
		userService.deleteSocialMedia(id);
		StandardResponse standardResponse = new StandardResponse(ResponseMessages.DELETE_MESSAGE, ResponseMessages.DELETE);
		
		return new ResponseEntity<>(standardResponse, HttpStatus.OK);
	}

	@PostMapping("send_form")
	public ResponseEntity<StandardResponse> sendForm( @RequestBody @Valid LeadInfoDto leadInfoDto) {
		StandardResponse<LeadInfoDto> standardResponse = new StandardResponse<LeadInfoDto>(leadInfoService.saveLeadInfoMsg(leadInfoDto),ResponseMessages.INSERT_MESSAGE, ResponseMessages.INSERT_CODE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	
	}
	
	

	@PostMapping("education")
	@Validated(OnCreateGroupValidation.class)
	public ResponseEntity<StandardResponse> createEducation( @RequestBody @Valid EducationDto educationDto) throws NotFoundException {
		//validating dates
		DateRangeDto dateRangeDto = new DateRangeDto(educationDto.getStartDate(), educationDto.getEndDate());
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<DateRangeDto>> violations = validator.validate(dateRangeDto);
	    if (!violations.isEmpty()) {
	        throw new ConstraintViolationException(violations);
	      }

		StandardResponse<EducationDto> standardResponse = new StandardResponse<EducationDto>(userService.createUpdateEducation(educationDto, null), ResponseMessages.INSERT_MESSAGE, ResponseMessages.INSERT_CODE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("education")
	@Validated(OnUpdateGroupValidation.class)
	public ResponseEntity<StandardResponse> updateEducation( @RequestBody @Valid EducationDto educationDto) throws NotFoundException{

		DateRangeDto dateRangeDto = new DateRangeDto(educationDto.getStartDate(), educationDto.getEndDate());
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<DateRangeDto>> violations = validator.validate(dateRangeDto);
		  if (!violations.isEmpty()) {
		        throw new ConstraintViolationException(violations);
		      }
		StandardResponse<EducationDto> standardResponse = new StandardResponse<EducationDto>(userService.createUpdateEducation(educationDto, "UPDATE"), ResponseMessages.UPDATE_MESSAGE, ResponseMessages.INSERT_CODE);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("education")
	public ResponseEntity<StandardResponse> deleteEducation(@RequestParam @NotNull int id){

		StandardResponse<Integer> standardResponse = new StandardResponse<Integer>(userService.deleteEducation(id), ResponseMessages.DELETE_MESSAGE, ResponseMessages.SUCCESS);
		return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
	}
	
	 @PostMapping("logout")
	 public ResponseEntity<StandardResponse<String>> logout(@RequestParam @NotNull int id) {
		 service.logoutUser(id);
		 StandardResponse<String> standardResponse = new StandardResponse<String>(null,"User Logged out Sucessfully", ResponseMessages.SUCCESS);
		 return new ResponseEntity<StandardResponse<String>>(standardResponse, HttpStatus.OK);
		 
	 }
	 
	 @PutMapping("update_password")
	 public ResponseEntity<StandardResponse<String>> resetPassword( @RequestBody @Valid ResetPasswordDto resetPasswordDto, @RequestHeader("Authorization") @NotBlank String token ) throws InvalidJwtException{
		 
		 CompareStringDto compareStringDto = new CompareStringDto(resetPasswordDto.getConfirmPassword(), resetPasswordDto.getNewPassword());
		 ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 Validator validator = factory.getValidator();
		 Set<ConstraintViolation<CompareStringDto>> violations = validator.validate(compareStringDto);
		
		    if (!violations.isEmpty()) {
		        throw new ConstraintViolationException(violations);
		      }
       		 token = token.replace("Bearer ", "");
		   
		 StandardResponse<String> standardResponse = new StandardResponse<String>(service.resetPassword(token, resetPasswordDto),"Update password done", ResponseMessages.SUCCESS);
		 return new ResponseEntity<StandardResponse<String>>(standardResponse, HttpStatus.OK);
	 }
	 

}
