package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.DeleteProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.GetProductPhotosRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.DeleteProductPhotoResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.GetProductPhotosResponse;

import java.util.List;

public interface ProductPhotoService {

	List<GetProductPhotosResponse> getProductPhotosByProductId(GetProductPhotosRequest request);
	
	DeleteProductPhotoResponse delete(DeleteProductPhotoRequest request);

	// AddProductPhotoResponse add(AddProductPhotoRequest request);
}
