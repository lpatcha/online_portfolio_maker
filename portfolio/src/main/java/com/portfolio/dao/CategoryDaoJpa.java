package com.portfolio.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.entity.Categories;

public interface CategoryDaoJpa extends JpaRepository<Categories, Long> {

	Categories findById(int id);
}
