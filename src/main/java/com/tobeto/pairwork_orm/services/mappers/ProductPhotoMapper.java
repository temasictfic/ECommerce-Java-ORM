package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoToProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.AddProductPhotoToProductResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.ListProductPhotoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPhotoMapper {
	ProductPhotoMapper INSTANCE = Mappers.getMapper(ProductPhotoMapper.class);

	ListProductPhotoResponse mapProductPhotoToListProductPhotoResponse(ProductPhoto productPhoto);

	ProductPhoto mapAddProductPhotoRequestToProductPhoto(AddProductPhotoToProductRequest request);

	AddProductPhotoToProductResponse mapAddProductPhotoResponseToProductPhoto(ProductPhoto productPhoto);
}
