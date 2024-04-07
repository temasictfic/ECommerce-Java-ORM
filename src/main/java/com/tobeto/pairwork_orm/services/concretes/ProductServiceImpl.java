package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.repositories.ProductPhotoRepository;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import com.tobeto.pairwork_orm.services.abstracts.ProductService;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.*;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoRequest;
import com.tobeto.pairwork_orm.services.mappers.ProductMapper;
import com.tobeto.pairwork_orm.services.mappers.ProductPhotoMapper;
import com.tobeto.pairwork_orm.services.rules.abstracts.ProductBusinessRuleService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	private ProductPhotoRepository productPhotoRepository;
	
	private ProductBusinessRuleService productBusinessRuleService;

	@Override
	public AddProductResponse add(AddProductRequest request) {
		
		productBusinessRuleService.productWithSameNameShouldNotExist(request.getProductName());
		
		// Product entity'sini oluşturma
		Product product = ProductMapper.INSTANCE.mapAddProductRequestToProduct(request);

		// Product ile ilişkilendirilmiş ProductPhoto nesnelerini oluşturma
		List<ProductPhoto> productPhotos = new ArrayList<>();

		if (request.getProductPhotos() != null) {
			for (AddProductPhotoRequest dto : request.getProductPhotos()) {
				ProductPhoto productPhoto = ProductPhotoMapper.INSTANCE.mapAddProductPhotoRequestToProductPhoto(dto);
				productPhoto.setProduct(product); // Product photo ile ilişkilendirme
				productPhotos.add(productPhoto);
			}
		}

		// Product ile ProductPhoto'ları ilişkilendirme
		product.setProductPhotos(productPhotos);

		// ProductRepository kullanarak Product'ı veritabanına ekleme
		productRepository.save(product);

		// ProductPhoto'ları kaydetme
		for (ProductPhoto productPhoto : productPhotos) {
			productPhotoRepository.save(productPhoto);
		}

		AddProductResponse response = new AddProductResponse("Product added.");

		return response;
	}

	@Override
	public UpdatedProductResponse update(UpdateProductRequest request) {
		Product existingProduct = ProductMapper.INSTANCE.mapUpdateProductRequestToProduct(request);

		productRepository.save(existingProduct);

		UpdatedProductResponse response = new UpdatedProductResponse("Product updated.");

		return response;
	}

	@Override
	public DeleteProductResponse delete(DeleteProductRequest request) {
		Product product = productRepository.findById(request.getProductId()).orElseThrow();

		productRepository.delete(product);

		DeleteProductResponse response = new DeleteProductResponse("Product deleted.");

		return response;
	}

	@Override
	public List<ListProductResponse> getAll() {
		List<Product> products = productRepository.findAll();

		List<ListProductResponse> response = products.stream()
				.map(ProductMapper.INSTANCE::mapProductToListProductResponse).collect(Collectors.toList());

		return response;
	}

	@Override
	public GetProductResponse getById(GetProductRequest request) {
		Product product = productRepository.findById(request.getProductId()).orElseThrow();

		GetProductResponse response = ProductMapper.INSTANCE.mapProductToGetProductResponse(product);

		return response;
	}
}
