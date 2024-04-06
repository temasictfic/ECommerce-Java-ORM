package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.Customer;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.AddCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.UpdateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer mapAddCustomerRequestToCustomer(AddCustomerRequest request);
    @Mapping(target = "id", source = "customerId")
    Customer mapUpdateCustomerRequestToCustomer(UpdateCustomerRequest request);
}
