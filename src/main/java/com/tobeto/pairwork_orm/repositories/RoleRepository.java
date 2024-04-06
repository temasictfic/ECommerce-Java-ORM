package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.ERole;
import com.tobeto.pairwork_orm.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByRoleName(ERole roleName);
}
