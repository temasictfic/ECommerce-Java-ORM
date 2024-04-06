package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.repositories.ProductPhotoRepository;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import com.tobeto.pairwork_orm.services.abstracts.ProductPhotoService;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.DeleteProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.ListProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.AddProductPhotoResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.DeleteProductPhotoResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.ListProductPhotoResponse;
import com.tobeto.pairwork_orm.services.mappers.ProductPhotoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

	private ProductPhotoRepository productPhotoRepository;

	private ProductRepository productRepository;

	@Override
	public AddProductPhotoResponse add(AddProductPhotoRequest request) {
		ProductPhoto productPhoto = ProductPhotoMapper.INSTANCE.mapAddProductPhotoRequestToProductPhoto(request);
		Product product = productRepository.findById(request.getProductId())
				.orElseThrow(()-> new BusinessException("Error: Requested product not found."));
		productPhoto.setProduct(product);
		productPhotoRepository.save(productPhoto);

		AddProductPhotoResponse response = ProductPhotoMapper.INSTANCE.mapAddProductPhotoResponseToProductPhoto(productPhoto);

		return response;
	}

	@Override
	public List<ListProductPhotoResponse> getProductPhotosByProductId(
			ListProductPhotoRequest request) {

		List<ProductPhoto> productPhotos = productPhotoRepository
				.findProductPhotosByProduct_ProductId(request.getProductId());

		List<ListProductPhotoResponse> response = new ArrayList<>();

		for (ProductPhoto productPhoto : productPhotos) {
			ListProductPhotoResponse photoResponse =
					ProductPhotoMapper.INSTANCE.mapProductPhotoToListProductPhotoResponse(productPhoto);

			response.add(photoResponse);
		}

		return response;
	}

	@Override
	public DeleteProductPhotoResponse delete(DeleteProductPhotoRequest request) {

		ProductPhoto photo = productPhotoRepository.findById(request.getProductPhotoId()).orElseThrow();

		productPhotoRepository.delete(photo);

		DeleteProductPhotoResponse response = new DeleteProductPhotoResponse("Product photo deleted.");

		return response;
	}

}
