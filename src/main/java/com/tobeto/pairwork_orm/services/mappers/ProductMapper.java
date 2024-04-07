package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.GetProductResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.ListProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Mapping(target = "category.categoryId", source = "categoryId")
	Product mapAddProductRequestToProduct(AddProductRequest request);
	
	@Mapping(target = "category.categoryId", source = "categoryId")
	Product mapUpdateProductRequestToProduct(UpdateProductRequest request);

	//@Mapping(target = "productPhotos", ignore = true) // Örnek olarak ignore edildi
	@Mapping(target = "categoryName", source = "category.categoryName")
    ListProductResponse mapProductToListProductResponse(Product product);

	@Mapping(target = "categoryName", source = "category.categoryName")
	GetProductResponse mapProductToGetProductResponse(Product product);
	
}
