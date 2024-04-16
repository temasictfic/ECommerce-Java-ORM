package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.orderDtos.requests.OrderRequest;
import com.tobeto.pairwork_orm.services.dtos.orderDtos.responses.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);
}
