package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPhotoMapper {
	ProductPhotoMapper INSTANCE = Mappers.getMapper(ProductPhotoMapper.class);

	@Mapping(target = "product.productId", source = "productId")
	ProductPhoto productPhotoFromAddRequest(AddProductPhotoRequest request);
}
