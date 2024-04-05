package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<CustomerAddress, Integer>{

}
