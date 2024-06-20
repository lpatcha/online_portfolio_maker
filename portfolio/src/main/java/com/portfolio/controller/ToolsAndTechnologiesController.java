package com.portfolio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.dto.CategoryDto;
import com.portfolio.dto.StandardResponse;
import com.portfolio.dto.ToolsAndTechnologiesDto;
import com.portfolio.entity.Categories;
import com.portfolio.entity.ToolsAndTechnologies;
import com.portfolio.services.CategoryService;
import com.portfolio.services.ToolsAndTechnologiesService;
import com.portfolio.utils.ResponseMessages;

@RestController
@RequestMapping("/api/toolsAndTechnologies")
public class ToolsAndTechnologiesController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ToolsAndTechnologiesService toolsAndTechnologiesService;
	

	@PostMapping("createCategory")
	public ResponseEntity<StandardResponse<Categories>>  addCategory(@RequestBody CategoryDto category ) {
		
		StandardResponse<Categories> standardResponse = new StandardResponse<>(categoryService.createCategory(category),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		
		return new ResponseEntity<StandardResponse<Categories>>(standardResponse, HttpStatus.CREATED);
		
	}
	

	@PostMapping("CreateToolsAndTechnologies")
	public ResponseEntity<StandardResponse<ToolsAndTechnologies>>  addToolsAndTechnologies(@RequestBody  ToolsAndTechnologiesDto toolsAndTechnologiesDto ) {
		
		/**
		 * Todo
		 * I want to change the relation between tools and technologies many to many what do you say about this ?
		 */
		
		
		StandardResponse<ToolsAndTechnologies> standardResponse = new StandardResponse<>(toolsAndTechnologiesService.addToolsAndTechnologies(toolsAndTechnologiesDto),ResponseMessages.INSERT_CODE, ResponseMessages.INSERT_MESSAGE);
		
		return new ResponseEntity<StandardResponse<ToolsAndTechnologies>>(standardResponse, HttpStatus.CREATED);
		
	}
}
