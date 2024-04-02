package com.tobeto.pairwork_orm.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.tobeto.pairwork_orm.services.abstracts.ProductPhotoService;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.DeleteProductPhotoByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.GetProductPhotosByProductIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.DeleteProductPhotoByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.GetProductPhotoByProductIdResponse;

@RestController
@RequestMapping("/api/product-photos")
public class ProductPhotosController {

	private ProductPhotoService photoService;

	public ProductPhotosController(ProductPhotoService photoService) {
		this.photoService = photoService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<GetProductPhotoByProductIdResponse> getProductPhotosByProductId(
			GetProductPhotosByProductIdRequest request) {
		return photoService.getProductPhotosByProductId(request);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public DeleteProductPhotoByIdResponse delete(DeleteProductPhotoByIdRequest request) {
		return photoService.delete(request);
	}

}
