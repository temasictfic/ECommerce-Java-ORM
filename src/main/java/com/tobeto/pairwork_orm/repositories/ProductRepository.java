package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
