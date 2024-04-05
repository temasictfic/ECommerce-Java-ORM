package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.entities.Customer;
import com.tobeto.pairwork_orm.repositories.CustomerRepository;
import com.tobeto.pairwork_orm.repositories.RoleRepository;
import com.tobeto.pairwork_orm.services.abstracts.CustomerService;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.AddCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.DeleteCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.UpdateCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.AddCustomerResponse;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.DeleteCustomerResponse;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.UpdateCustomerResponse;
import com.tobeto.pairwork_orm.services.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	private RoleRepository roleRepository;

	private UserBusinessRules userBusinessRules;

	@Override
	public AddCustomerResponse add(AddCustomerRequest request) {

		/*userBusinessRules.checkIfUsernameAlreadyExists(request.getUsername());
		userBusinessRules.checkIfEmailAlreadyExists(request.getEmail());

		Customer customer = this.mapperService.forRequest().map(request, Customer.class);

		Set<String> requestedRoles = request.getRoles();

		Set<Role> roles = new HashSet<>();

		Role customerRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
				.orElseThrow(() -> new BusinessException("Error: Role is not found."));
		roles.add(customerRole);

		if (requestedRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new BusinessException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			requestedRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new BusinessException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "seller":
					Role sellerRole = roleRepository.findByName(ERole.ROLE_SELLER)
							.orElseThrow(() -> new BusinessException("Error: Role is not found."));
					roles.add(sellerRole);
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new BusinessException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		customer.setRoles(roles);

		customerRepository.save(customer);*/

		AddCustomerResponse response = new AddCustomerResponse("Customer added.");

		return response;
	}

	@Override
	public UpdateCustomerResponse update(UpdateCustomerRequest request) {
		
		/*userBusinessRules.checkIfUsernameAlreadyExists(request.getUsername());
		userBusinessRules.checkIfEmailAlreadyExists(request.getEmail());
		
		Customer existingCustomer = customerRepository.findById(request.getCustomerId())
				.orElseThrow(() -> new BusinessException("Error: Customer is not found."));

		existingCustomer = this.mapperService.forRequest().map(request, Customer.class);

		customerRepository.save(existingCustomer);*/

		UpdateCustomerResponse response = new UpdateCustomerResponse("Customer updated.");

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
