package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.services.abstracts.ProductPhotoService;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.DeleteProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.GetProductPhotosRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.DeleteProductPhotoResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.GetProductPhotosResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-photos")
public class ProductPhotosController {

	private ProductPhotoService photoService;

	public ProductPhotosController(ProductPhotoService photoService) {
		this.photoService = photoService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<GetProductPhotosResponse> getProductPhotosByProductId(
			GetProductPhotosRequest request) {
		return photoService.getProductPhotosByProductId(request);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public DeleteProductPhotoResponse delete(DeleteProductPhotoRequest request) {
		return photoService.delete(request);
	}

}
