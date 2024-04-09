package com.tobeto.pairwork_orm.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.pairwork_orm.entities.CartProduct;
import com.tobeto.pairwork_orm.services.dtos.cartProductDtos.requests.AddCartProductRequest;

@Mapper
public interface CartProductMapper {
    CartProductMapper INSTANCE = Mappers.getMapper(CartProductMapper.class);
    
    /*@Mapping(target = "cart.cartId", source = "cartId")
    @Mapping(target = "product.productId", source = "productId")
    @Mapping(target = "seller.id", source = "sellerId")
    CartProduct mapAddCartProductRequestToCartProduct(AddCartProductRequest request);*/
}
