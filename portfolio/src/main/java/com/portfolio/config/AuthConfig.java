package com.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.portfolio.services.AuthService;

@Configuration
@EnableWebSecurity
public class AuthConfig {
	
	 
	 @Autowired
	  SecurityFilter securityFilter;
	 
	 @Autowired
	 AuthService authServiceImpl;
	 
	
	 

	  @Bean
	  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	    return httpSecurity
	        .csrf(csrf -> csrf.disable())
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(authorize -> authorize

//	        	.requestMatchers("/api/toolsAndTechnologies/*").permitAll()
//	        	.requestMatchers("/api/user/*").permitAll()
	        	.requestMatchers("/api/auth/*").permitAll()
	        	 .anyRequest().authenticated()

	        	)
	        	.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
	        .build();
	  }

	  @Bean
	  AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration, HttpSecurity http)
	      throws Exception {
	   
	    AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
	    authenticationManagerBuilder.userDetailsService(authServiceImpl).passwordEncoder(passwordEncoder());
	    return authenticationManagerBuilder.build();		
	  }

	  @Bean
	  @Qualifier("passwordEncoder")
	  PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	  
	//  .anyRequest().authenticated()

} 
