package com.tobeto.pairwork_orm.services.dtos.orderDtos.responses;

import java.util.List;

import com.tobeto.pairwork_orm.services.dtos.orderProductDtos.responses.OrderProductResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private int orderId;
    private LocalDate orderCreatedDate;
    private LocalDate orderShippedDate;
    private LocalDate orderDeliveredDate;
    private LocalDate estimatedDeliveryDate;
    private LocalDate orderReturnedDate;
    private String orderStatus;
    private int customerId;
    private int customerAddressId;
    private List<OrderProductResponse> orderProducts;
}