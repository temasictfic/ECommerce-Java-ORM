package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.AddCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.DeleteCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.UpdateCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.AddCustomerResponse;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.DeleteCustomerResponse;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.responses.UpdatedCustomerResponse;

public interface CustomerService {
	AddCustomerResponse add(AddCustomerRequest request);
	
	UpdatedCustomerResponse update(UpdateCustomerRequest request);
	
	DeleteCustomerResponse delete(DeleteCustomerRequest request);
}
