package com.tobeto.pairwork_orm.services.abstracts;

import java.util.List;

import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.DeleteProductPhotoByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.GetProductPhotosByProductIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.DeleteProductPhotoByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.GetProductPhotoByProductIdResponse;

public interface ProductPhotoService {

	List<GetProductPhotoByProductIdResponse> getProductPhotosByProductId(GetProductPhotosByProductIdRequest request);
	
	DeleteProductPhotoByIdResponse delete(DeleteProductPhotoByIdRequest request);

	// AddProductPhotoResponse add(AddProductPhotoRequest request);
}
