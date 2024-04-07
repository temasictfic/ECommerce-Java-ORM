package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
}
