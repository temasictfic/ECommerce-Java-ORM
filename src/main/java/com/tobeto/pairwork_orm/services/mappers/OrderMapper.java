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


    @Mapping(target = "customer", source = "customerId", qualifiedByName = "customerIdToCustomer")
    @Mapping(target = "customerAddress", source = "customerAddressId", qualifiedByName = "customerAddressIdToCustomerAddress")
    Order mapOrderRequestToOrder(OrderRequest request);

    @Mapping(target = "orderId", source = "orderId")
    @Mapping(target = "orderCreatedDate", source = "orderCreatedDate")
    @Mapping(target = "orderShippedDate", source = "orderShippedDate")
    @Mapping(target = "orderDeliveredDate", source = "orderDeliveredDate")
    @Mapping(target = "estimatedDeliveryDate", source = "estimatedDeliveryDate")
    @Mapping(target = "orderReturnedDate", source = "orderReturnedDate")
    @Mapping(target = "orderStatus", source = "orderStatus")
    @Mapping(target = "customerId", source = "customer")
    @Mapping(target = "customerAddressId", source = "customerAddress")
    OrderResponse mapOrderToOrderResponse(Order order);
}
