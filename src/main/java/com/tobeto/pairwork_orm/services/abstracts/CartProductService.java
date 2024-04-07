package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.cartProductDtos.requests.AddProductToCartProductRequest;
import com.tobeto.pairwork_orm.services.dtos.cartProductDtos.responses.AddProductToCartProductResponse;

public interface CartProductService {
    AddProductToCartProductResponse addProductToCart(AddProductToCartProductRequest request);
}
