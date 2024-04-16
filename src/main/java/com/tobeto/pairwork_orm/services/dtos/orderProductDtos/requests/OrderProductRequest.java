package com.tobeto.pairwork_orm.services.dtos.orderProductDtos.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductRequest {
    @NotNull(message = "Product ID cannot be null.")
    private int productId;

    @NotNull(message = "Seller ID cannot be null.")
    private int sellerId;

    @Positive(message = "Quantity must be greater than zero.")
    private int quantity;
}
