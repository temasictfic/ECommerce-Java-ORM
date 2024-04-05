package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
}
