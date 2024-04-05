package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Optional<Category> findByCategoryNameIgnoreCase(String categoryName);
	
}
