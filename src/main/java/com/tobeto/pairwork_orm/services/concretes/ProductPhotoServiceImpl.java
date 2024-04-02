package com.tobeto.pairwork_orm.services.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.pairwork_orm.core.utilities.mapping.ModelMapperService;
import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.repositories.ProductPhotoRepository;
import com.tobeto.pairwork_orm.services.abstracts.ProductPhotoService;
import com.tobeto.pairwork_orm.services.abstracts.ProductService;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.AddProductResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.DeleteProductByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.GetProductByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.ListProductResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.UpdatedProductResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.DeleteProductPhotoByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.GetProductPhotosByProductIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.DeleteProductPhotoByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.GetProductPhotoByProductIdResponse;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

	private ProductPhotoRepository productPhotoRepository;

	private ModelMapperService modelMapperService;

	public ProductPhotoServiceImpl(ProductPhotoRepository productPhotoRepository,
			ModelMapperService modelMapperService) {
		this.productPhotoRepository = productPhotoRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetProductPhotoByProductIdResponse> getProductPhotosByProductId(
			GetProductPhotosByProductIdRequest request) {

		List<ProductPhoto> productPhotos = productPhotoRepository
				.getProductPhotosByProduct_ProductId(request.getProductId());

		List<GetProductPhotoByProductIdResponse> response = new ArrayList<>();

		for (ProductPhoto dto : productPhotos) {
			GetProductPhotoByProductIdResponse photoResponse = this.modelMapperService.forResponse().map(dto,
					GetProductPhotoByProductIdResponse.class);

			/*
			 * photoResponse.setProductPhotoId(productPhoto.getId());
			 * photoResponse.setProductPhotoUrl(productPhoto.getProductPhotoUrl());
			 */

			response.add(photoResponse);
		}

		return response;
	}

	@Override
	public DeleteProductPhotoByIdResponse delete(DeleteProductPhotoByIdRequest request) {

		ProductPhoto photo = productPhotoRepository.findById(request.getId()).orElseThrow();

		productPhotoRepository.delete(photo);

		DeleteProductPhotoByIdResponse response = new DeleteProductPhotoByIdResponse("Product photo deleted.");

		return response;
	}

}
