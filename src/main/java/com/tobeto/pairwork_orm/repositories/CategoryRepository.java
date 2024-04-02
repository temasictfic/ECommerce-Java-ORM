package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.Category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Optional<Category> findByCategoryNameIgnoreCase(String name);
	
}
