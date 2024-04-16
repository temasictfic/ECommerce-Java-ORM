package com.tobeto.pairwork_orm.services.dtos.orderDtos.requests;
import java.util.List;

import com.tobeto.pairwork_orm.services.dtos.orderProductDtos.requests.OrderProductRequest;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    @NotNull(message = "Customer ID cannot be null.")
    private int customerId;

    @NotNull(message = "Customer address ID cannot be null.")
    private int customerAddressId;

    @NotEmpty(message = "Order must contain at least one product.")
    private List<OrderProductRequest> orderProducts;
}
