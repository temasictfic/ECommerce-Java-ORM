package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
