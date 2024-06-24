package com.portfolio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.dto.CategoryDto;
import com.portfolio.dto.StandardResponse;
import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.dto.UserToolsAndTechnologiesDto;
import com.portfolio.entity.Categories;
import com.portfolio.entity.ToolsAndTechnologies;
import com.portfolio.services.CategoryService;
import com.portfolio.services.ToolsAndTechnologiesService;
import com.portfolio.utils.ResponseMessages;

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
	public ResponseEntity<StandardResponse<Categories>>  addCategory(@RequestBody CategoryDto category ) {
		
		StandardResponse<Categories> standardResponse = new StandardResponse<>(categoryService.createCategory(category),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		
		return new ResponseEntity<StandardResponse<Categories>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@PutMapping("updateCategory")
	public ResponseEntity<StandardResponse<Categories>>  updateCategory(@RequestBody CategoryDto category ) {
		StandardResponse<Categories> standardResponse = new StandardResponse<>(categoryService.updateCategory(category),ResponseMessages.SUCCESS, ResponseMessages.INSERT_MESSAGE);
		return new ResponseEntity<StandardResponse<Categories>>(standardResponse, HttpStatus.OK);
	}
	
	

	@PostMapping("CreateToolsAndTechnologies")
	public ResponseEntity<StandardResponse<ToolsAndTechnologiesDto>>  addToolsAndTechnologies(@RequestBody  ToolsAndTechnologiesDto toolsAndTechnologiesDto ) {
		
		/**
		 * Todo
		 * I want to change the relation between tools and technologies many to many what do you say about this ?
		 */
		
		
		StandardResponse<ToolsAndTechnologiesDto> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.addToolsAndTechnologies(toolsAndTechnologiesDto),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		
		return new ResponseEntity<StandardResponse<ToolsAndTechnologiesDto>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@PutMapping("updateToolsAndTechnologies")
	public ResponseEntity<StandardResponse<ToolsAndTechnologiesDto>>  updateToolsAndTechnologies(@RequestBody  ToolsAndTechnologiesDto toolsAndTechnologiesDto ) {
		
		
		
		StandardResponse<ToolsAndTechnologiesDto> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.updateToolsAndTechologies(toolsAndTechnologiesDto),ResponseMessages.SUCCESS, ResponseMessages.INSERT_MESSAGE);
		
		return new ResponseEntity<StandardResponse<ToolsAndTechnologiesDto>>(standardResponse, HttpStatus.OK);
		
	}
	
	@PostMapping("createUserToolsAndTechnologies")
	public ResponseEntity<StandardResponse<UserToolsAndTechnologiesDto>> createUserToolsAndTechnologies(@RequestBody  UserToolsAndTechnologiesDto userToolsAndTechnologiesDto ) {
		
		StandardResponse<UserToolsAndTechnologiesDto> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.createAndUpdateUserToolsAndTechnologies(userToolsAndTechnologiesDto, "SAVE"),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		
		return new ResponseEntity<StandardResponse<UserToolsAndTechnologiesDto>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@PutMapping("updateUserToolsAndTechnologies")
	public ResponseEntity<StandardResponse<UserToolsAndTechnologiesDto>> updateUserToolsAndTechnologies(@RequestBody  UserToolsAndTechnologiesDto userToolsAndTechnologiesDto ) {
		
		StandardResponse<UserToolsAndTechnologiesDto> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.createAndUpdateUserToolsAndTechnologies(userToolsAndTechnologiesDto, "UPDATE"),ResponseMessages.SUCCESS, ResponseMessages.UPDATE_MESSAGE);
		
		return new ResponseEntity<StandardResponse<UserToolsAndTechnologiesDto>>(standardResponse, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("deleteUserToolsAndTechnologies")
	public ResponseEntity<StandardResponse<Integer>> deleteUserToolsAndTechnologies(@RequestParam long id){
		
		StandardResponse<Integer> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.deleteUserToolsAndTechnologies(id),ResponseMessages.SUCCESS, ResponseMessages.DELETE_MESSAGE);
		
		return new ResponseEntity<StandardResponse<Integer>>(standardResponse, HttpStatus.OK);
	}
	
}
