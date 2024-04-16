package com.tobeto.pairwork_orm.services.dtos.orderProductDtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductResponse {
    private int orderProductId;
    private int productId;
    private int sellerId;
    private int quantity;
    private double totalPrice;
}