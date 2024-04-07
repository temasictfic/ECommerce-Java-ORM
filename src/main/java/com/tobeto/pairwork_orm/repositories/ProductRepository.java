package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.Product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByProductNameIgnoreCase(String productName);
}
