package com.tobeto.pairwork_orm.services.rules;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessRules {

	private UserRepository userRepository;

	public UserBusinessRules(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void checkIfUsernameAlreadyExists(String username) {
		this.userRepository.getByUsername(username).ifPresent(customer -> {
			throw new BusinessException(customer.getUsername() + " zaten mevcut.");
		});
	}

	public void checkIfEmailAlreadyExists(String email) {
		this.userRepository.getByEmail(email).ifPresent(customer -> {
			throw new BusinessException(customer.getEmail() + " zaten mevcut.");
		});
	}

}
