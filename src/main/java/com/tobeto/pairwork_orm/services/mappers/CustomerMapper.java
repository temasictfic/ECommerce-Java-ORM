package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.Customer;
import com.tobeto.pairwork_orm.entities.CustomerAddress;
import com.tobeto.pairwork_orm.repositories.CustomerAddressRepository;
import com.tobeto.pairwork_orm.repositories.CustomerRepository;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.AddCustomerRequest;
import com.tobeto.pairwork_orm.services.dtos.customerDtos.requests.UpdateCustomerRequest;

import lombok.Builder.Default;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer mapAddCustomerRequestToCustomer(AddCustomerRequest request);
    @Mapping(target = "id", source = "customerId")
    Customer mapUpdateCustomerRequestToCustomer(UpdateCustomerRequest request);

    @Named("customerIdToCustomer")
    default Customer customerIdToCustomer(int customerId, @Context CustomerRepository customerRepository) {
        return customerRepository.findById(customerId).orElse(null);
    }
    
    @Named("customerAddressIdToCustomerAddress")
    default CustomerAddress customerAddressIdToCustomerAddress(int customerAddressId, @Context CustomerAddressRepository customerAddressRepository) {
        return customerAddressRepository.findById(customerAddressId).orElse(null);
    }
    
}
