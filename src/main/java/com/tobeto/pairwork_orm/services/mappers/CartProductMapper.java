package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.CartProduct;
import com.tobeto.pairwork_orm.services.dtos.cartProductDtos.requests.AddProductToCartProductRequest;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CartProductMapper {
    CartProductMapper INSTANCE = Mappers.getMapper(CartProductMapper.class);

    @Mapping(source = "cart.cartId", target = "cartId")
    @Mapping(source = "product.productId", target = "productId")
    @Mapping(source = "seller.sellerId", target = "sellerId")
    CartProduct mapAddProductToCartProductRequestToCartProduct(AddProductToCartProductRequest request);
}
