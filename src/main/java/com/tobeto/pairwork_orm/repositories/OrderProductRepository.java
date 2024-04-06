package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer>{

}
