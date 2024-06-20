package com.portfolio;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.portfolio.dao.UserDao;
import com.portfolio.services.CategoryService;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner( CategoryService categoryService, UserDao userDao) {
		
		
		return runner -> {
			
			
//			System.out.println("application started");
//			System.out.println(userDao.findUserByUserName("lokeshp3098@gmail.com"));
     		//System.out.println(categoryService.findCategoryById(1));
//			
			
		};
		
	}
	
	@Bean()
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
}
