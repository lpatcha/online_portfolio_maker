package com.portfolio.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.portfolio.exceptionHandling.InvalidJwtException;
import com.portfolio.services.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{
	 @Autowired
	  TokenProvider tokenService;
	 
	  
	  @Autowired
	  AuthService authServiceImp;
	  
	  
	  @Override
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	      throws ServletException, IOException{
	    String token = this.recoverToken(request);
	  
	    if (token != null) {
	      String userName;
		try {
			userName = tokenService.validateToken(token);
			// todo exeption if no user is found in db
		      UserDetails user  = authServiceImp.loadUserByUsername(userName);
		      //todo don't store everything into signature only store which is necessary
		      var authentication = new UsernamePasswordAuthenticationToken(user, null, null);
		      SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (InvalidJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	    }
	    filterChain.doFilter(request, response);
	  }
	  
	  private String recoverToken(HttpServletRequest request) {
		    var authHeader = request.getHeader("Authorization");
		   
		    if (authHeader == null)
		      return null;
		    return authHeader.replace("Bearer ", "");
		  }
		}
