package com.portfolio;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PortfolioApplication {
	
	/**
	 * 
	 * Todo
	 * 1. exception handling
	 * 2. get user profile based on id
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
	
		@Bean
	    public ModelMapper getModelMapper() {
	        return new ModelMapper();
	    }
	

	
}
