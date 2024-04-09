package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.entities.Seller;
import com.tobeto.pairwork_orm.repositories.ProductPhotoRepository;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import com.tobeto.pairwork_orm.repositories.SellerRepository;
import com.tobeto.pairwork_orm.services.abstracts.ProductService;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AssignProductSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.*;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoToProductRequest;
import com.tobeto.pairwork_orm.services.mappers.ProductMapper;
import com.tobeto.pairwork_orm.services.mappers.ProductPhotoMapper;
import com.tobeto.pairwork_orm.services.mappers.SellerMapper;
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
	
	private SellerRepository sellerRepository;

	private ProductPhotoRepository productPhotoRepository;
	
	private ProductBusinessRuleService productBusinessRuleService;

	@Override
	public AddProductResponse add(AddProductRequest request) {
		
		productBusinessRuleService.productWithSameNameShouldNotExist(request.getProductName());
		
		// Product entity'sini oluşturma
		Product product = ProductMapper.INSTANCE.mapAddProductRequestToProduct(request);
		
		List<Seller> sellers = new ArrayList<>();
		/*List<Product> sellerProducts = new ArrayList<>();
		sellerProducts.add(product);*/

		// Product ile ilişkilendirilmiş ProductPhoto nesnelerini oluşturma
		List<ProductPhoto> productPhotos = new ArrayList<>();

		if (request.getProductPhotos() != null) {
			for (AddProductPhotoToProductRequest dto : request.getProductPhotos()) {
				ProductPhoto productPhoto = ProductPhotoMapper.INSTANCE.mapAddProductPhotoRequestToProductPhoto(dto);
				productPhoto.setProduct(product); // Product photo ile ilişkilendirme
				productPhotos.add(productPhoto);
			}
		}

		// Product ile ProductPhoto'ları ilişkilendirme
		product.setProductPhotos(productPhotos);
		
		if (request.getSellers() != null) {
			for (AssignProductSellerRequest dto : request.getSellers()) {
				Seller seller = SellerMapper.INSTANCE.mapAssignProductSellerToProductRequest(dto);
				//seller.setProducts(sellerProducts);
				sellers.add(seller);
			}
		}
		
		// Product ile Seller'ları ilişkilendirme
		product.setSellers(sellers);

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

	@Override
	public AssignProductSellerResponse assignProductToSeller(AssignProductSellerRequest request) {
		
		Seller seller = sellerRepository.findById(request.getSellerId()).orElseThrow();
		
		Product product = productRepository.findById(request.getProductId()).orElseThrow();
		
		product.getSellers().add(seller);
		
		productRepository.save(product);
		
		AssignProductSellerResponse response = new AssignProductSellerResponse("Product assigned to seller.");
		
		return response;
	}
}
