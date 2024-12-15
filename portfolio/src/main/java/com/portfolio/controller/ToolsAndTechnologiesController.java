package com.portfolio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.dto.CategoryDto;
import com.portfolio.dto.OnCreateGroupValidation;
import com.portfolio.dto.OnUpdateGroupValidation;
import com.portfolio.dto.StandardResponse;
import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.dto.UserToolsAndTechnologiesDto;
import com.portfolio.entity.Categories;
import com.portfolio.exceptionHandling.NotFoundException;
import com.portfolio.services.CategoryService;
import com.portfolio.services.ToolsAndTechnologiesService;
import com.portfolio.utils.ResponseMessages;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;


@Validated
@RestController
@RequestMapping("/api/toolsAndTechnologies")
public class ToolsAndTechnologiesController {
	/**
	 * TODO
	 * All the validations need to be performed
	 * error handling needs to be done.
	 */
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ToolsAndTechnologiesService toolsAndTechnologiesService;
	

	@PostMapping("createCategory")
	@Validated(OnCreateGroupValidation.class)
	public ResponseEntity<StandardResponse<Categories>>  addCategory( @RequestBody @Valid CategoryDto category ) {
		
		StandardResponse<Categories> standardResponse = new StandardResponse<>(categoryService.createCategory(category),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		
		return new ResponseEntity<StandardResponse<Categories>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@PutMapping("updateCategory")
	@Validated(OnUpdateGroupValidation.class)
	public ResponseEntity<StandardResponse<Categories>>  updateCategory( @RequestBody @Valid CategoryDto category ) {
		StandardResponse<Categories> standardResponse = new StandardResponse<>(categoryService.updateCategory(category),ResponseMessages.SUCCESS, ResponseMessages.INSERT_MESSAGE);
		return new ResponseEntity<StandardResponse<Categories>>(standardResponse, HttpStatus.OK);
	}
	
	

	@PostMapping("createToolsAndTechnologies")
	@Validated(OnCreateGroupValidation.class)
	public ResponseEntity<StandardResponse<ToolsAndTechnologiesDto>>  addToolsAndTechnologies(@RequestBody  @Valid  ToolsAndTechnologiesDto toolsAndTechnologiesDto ) {
		StandardResponse<ToolsAndTechnologiesDto> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.addToolsAndTechnologies(toolsAndTechnologiesDto),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		return new ResponseEntity<StandardResponse<ToolsAndTechnologiesDto>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@PutMapping("updateToolsAndTechnologies")
	@Validated(OnUpdateGroupValidation.class)
	public ResponseEntity<StandardResponse<ToolsAndTechnologiesDto>>  updateToolsAndTechnologies(@RequestBody  @Valid  ToolsAndTechnologiesDto toolsAndTechnologiesDto ) {
	
		StandardResponse<ToolsAndTechnologiesDto> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.addToolsAndTechnologies(toolsAndTechnologiesDto),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		return new ResponseEntity<StandardResponse<ToolsAndTechnologiesDto>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	// delete tools and technologies this should be done in future
	
	
	

	
	@PostMapping("createUserToolsAndTechnologies")
	@Validated(OnCreateGroupValidation.class)
	public ResponseEntity<StandardResponse<UserToolsAndTechnologiesDto>> createUserToolsAndTechnologies( @RequestBody @Valid UserToolsAndTechnologiesDto userToolsAndTechnologiesDto ) throws NotFoundException {
		
		StandardResponse<UserToolsAndTechnologiesDto> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.createAndUpdateUserToolsAndTechnologies(userToolsAndTechnologiesDto, "SAVE"),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		
		return new ResponseEntity<StandardResponse<UserToolsAndTechnologiesDto>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@PutMapping("updateUserToolsAndTechnologies")
	@Validated(OnUpdateGroupValidation.class)
	public ResponseEntity<StandardResponse<UserToolsAndTechnologiesDto>> updateUserToolsAndTechnologies( @RequestBody @Valid UserToolsAndTechnologiesDto userToolsAndTechnologiesDto ) throws NotFoundException {
		
		StandardResponse<UserToolsAndTechnologiesDto> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.createAndUpdateUserToolsAndTechnologies(userToolsAndTechnologiesDto, "UPDATE"),ResponseMessages.SUCCESS, ResponseMessages.UPDATE_MESSAGE);
		return new ResponseEntity<StandardResponse<UserToolsAndTechnologiesDto>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("deleteUserToolsAndTechnologies")
	public ResponseEntity<StandardResponse<Integer>> deleteUserToolsAndTechnologies(@RequestParam @Min(value = 1, message = "id cannot be null") long id){
		
		StandardResponse<Integer> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.deleteUserToolsAndTechnologies(id),ResponseMessages.SUCCESS, ResponseMessages.DELETE_MESSAGE);
		
		return new ResponseEntity<StandardResponse<Integer>>(standardResponse, HttpStatus.OK);
	}
	

	
}
