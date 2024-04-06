package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.AddProductPhotoResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.ListProductPhotoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPhotoMapper {
	ProductPhotoMapper INSTANCE = Mappers.getMapper(ProductPhotoMapper.class);

	ListProductPhotoResponse mapProductPhotoToListProductPhotoResponse(ProductPhoto productPhoto);

	ProductPhoto mapAddProductPhotoRequestToProductPhoto(AddProductPhotoRequest request);

	AddProductPhotoResponse mapAddProductPhotoResponseToProductPhoto(ProductPhoto productPhoto);
}
