package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.services.abstracts.CustomerService;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.AddCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.DeleteCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.UpdateCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.AddCustomerResponse;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.DeleteCustomerResponse;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.UpdatedCustomerResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

	private CustomerService customerService;

	public CustomersController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCustomerResponse add(@RequestBody @Valid AddCustomerRequest request) {
        return customerService.add(request);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCustomerResponse update(@RequestBody @Valid UpdateCustomerRequest request) {
        return customerService.update(request);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public DeleteCustomerResponse delete(DeleteCustomerRequest request) {
        return customerService.delete(request);
    }

}
