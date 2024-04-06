package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.entities.Customer;
import com.tobeto.pairwork_orm.entities.ERole;
import com.tobeto.pairwork_orm.entities.Role;
import com.tobeto.pairwork_orm.repositories.CustomerRepository;
import com.tobeto.pairwork_orm.repositories.RoleRepository;
import com.tobeto.pairwork_orm.services.abstracts.CustomerService;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.AddCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.DeleteCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.UpdateCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.AddCustomerResponse;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.DeleteCustomerResponse;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.UpdatedCustomerResponse;
import com.tobeto.pairwork_orm.services.mappers.CustomerMapper;
import com.tobeto.pairwork_orm.services.rules.concretes.UserBusinessRuleImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	private RoleRepository roleRepository;

	private UserBusinessRuleImpl userBusinessRules;

	@Override
	public AddCustomerResponse add(AddCustomerRequest request) {

		userBusinessRules.checkIfUsernameAlreadyExists(request.getUsername());
		userBusinessRules.checkIfEmailAlreadyExists(request.getEmail());

		Customer customer = CustomerMapper.INSTANCE.mapAddCustomerRequestToCustomer(request);

		Set<Role> roles = new HashSet<>();

		Role customerRole = roleRepository.findByRoleName(ERole.ROLE_CUSTOMER)
				.orElseThrow(() -> new BusinessException("Error: Role is not found."));
		roles.add(customerRole);

		Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
				.orElseThrow(() -> new BusinessException("Error: Role is not found."));
		roles.add(userRole);

		customer.setRoles(roles);

		customerRepository.save(customer);

		AddCustomerResponse response = new AddCustomerResponse("Customer added.");

		return response;
	}

	@Override
	public UpdatedCustomerResponse update(UpdateCustomerRequest request) {
		Customer existingCustomer= CustomerMapper.INSTANCE.mapUpdateCustomerRequestToCustomer(request);

		customerRepository.save(existingCustomer);

		UpdatedCustomerResponse response = new UpdatedCustomerResponse("Customer updated.");

		return response;
	}

	@Override
	public DeleteCustomerResponse delete(DeleteCustomerRequest request) {

		Customer existingCustomer = customerRepository.findById(request.getCustomerId())
				.orElseThrow(() -> new BusinessException("Error: Customer is not found."));

		customerRepository.delete(existingCustomer);

		DeleteCustomerResponse response = new DeleteCustomerResponse("Customer deleted.");

		return response;
	}

}
