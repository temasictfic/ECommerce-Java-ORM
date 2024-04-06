package com.tobeto.pairwork_orm.services.rules.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.repositories.UserRepository;
import com.tobeto.pairwork_orm.services.rules.abstracts.UserBusinessRuleService;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessRuleImpl implements UserBusinessRuleService {

	private UserRepository userRepository;

	public UserBusinessRuleImpl(UserRepository userRepository) {
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
