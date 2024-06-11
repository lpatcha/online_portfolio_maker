package com.portfolio;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.portfolio.services.CategoryServiceImp;
@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(CategoryServiceImp categoryService) {
		
		
		return runner -> {
			System.out.println("application started");
			//categoryService.findCategoryById(1);
			
			
		};
		
	}
	
	@Bean()
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
}
