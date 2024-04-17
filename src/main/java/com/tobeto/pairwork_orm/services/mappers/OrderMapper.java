package com.tobeto.pairwork_orm.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.pairwork_orm.entities.Order;
import com.tobeto.pairwork_orm.services.dtos.orderDtos.requests.OrderRequest;
import com.tobeto.pairwork_orm.services.dtos.orderDtos.responses.OrderResponse;

@Mapper(uses = CustomerMapper.class)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    @Mapping(target = "customer", source = "customerId.id", qualifiedByName = "customerIdToCustomer")
    @Mapping(target = "customerAddress", source = "customerAddressId.customerAddressId", qualifiedByName = "customerAddressIdToCustomerAddress")
    Order mapOrderRequestToOrder(OrderRequest request);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "customerAddressId", source = "customerAddress.customerAddressId")
    OrderResponse mapOrderToOrderResponse(Order order);
}
