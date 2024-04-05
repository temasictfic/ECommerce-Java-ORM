package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
