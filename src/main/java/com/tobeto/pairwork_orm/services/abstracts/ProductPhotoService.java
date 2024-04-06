package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.DeleteProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.ListProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.AddProductPhotoResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.DeleteProductPhotoResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.ListProductPhotoResponse;

import java.util.List;

public interface ProductPhotoService {

	AddProductPhotoResponse add(AddProductPhotoRequest request);

	List<ListProductPhotoResponse> getProductPhotosByProductId(ListProductPhotoRequest request);
	
	DeleteProductPhotoResponse delete(DeleteProductPhotoRequest request);

	// AddProductPhotoResponse add(AddProductPhotoRequest request);
}
