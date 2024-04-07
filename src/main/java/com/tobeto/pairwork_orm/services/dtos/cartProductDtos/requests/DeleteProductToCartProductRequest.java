package com.tobeto.pairwork_orm.services.dtos.cartProductDtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductToCartProductRequest {
    private int productId;
}
