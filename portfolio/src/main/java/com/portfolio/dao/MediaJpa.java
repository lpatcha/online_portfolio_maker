package com.portfolio.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.entity.Media;


public interface MediaJpa extends JpaRepository<Media, Integer>{
	Media findById(int id);
	

}
