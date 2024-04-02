package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.core.utilities.mapping.ModelMapperService;
import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.repositories.CategoryRepository;
import com.tobeto.pairwork_orm.repositories.ProductPhotoRepository;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import com.tobeto.pairwork_orm.services.abstracts.ProductService;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.*;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoRequest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    
    private CategoryRepository categoryRepository;
    
    private ProductPhotoRepository productPhotoRepository;
    
    private ModelMapperService  modelMapperService;

 
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductPhotoRepository productPhotoRepository,
    		ModelMapperService modelMapperService) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.productPhotoRepository = productPhotoRepository;
		this.modelMapperService = modelMapperService;
	}
    
    @Override
    public AddProductResponse add(AddProductRequest request) {
    	
    	Category existingCategory = categoryRepository.findById(request.getCategoryId()).orElseThrow();
    	
        // Product entity'sini oluşturma
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setPackageHeight(request.getPackageHeight());
        product.setPackageWidth(request.getPackageWidth());
        product.setPackageWeight(request.getPackageWeight());
        product.setUnitPrice(request.getUnitPrice());
        product.setUnitInStock(request.getUnitInStock());
        product.setCategory(existingCategory);
        
        // Product ile ilişkilendirilmiş ProductPhoto nesnelerini oluşturma
        List<ProductPhoto> productPhotos = new ArrayList<>();
        if (request.getProductPhotos() != null) {
            for (AddProductPhotoRequest dto : request.getProductPhotos()) {
                ProductPhoto productPhoto = this.modelMapperService.forRequest().map(dto, ProductPhoto.class);
                productPhoto.setProduct(product); // Product photo ile ilişkilendirme
                productPhotos.add(productPhoto);
            }
        }

        // Product ile ilişkilendirme
        product.setProductPhotos(productPhotos);

        // ProductRepository kullanarak Product'ı veritabanına ekleme
        Product createdProduct = productRepository.save(product);

        // ProductPhoto'ları kaydetme
        for (ProductPhoto productPhoto : productPhotos) {
            productPhotoRepository.save(productPhoto);
        }
        
        AddProductResponse response = this.modelMapperService.forResponse()
                .map(createdProduct, AddProductResponse.class);

        return response;
    }

    @Override
    public UpdatedProductResponse update(UpdateProductRequest request) {
    	Product existingProduct = productRepository.findById(request.getProductId()).orElseThrow();
    	
    	this.modelMapperService.forRequest().map(request, existingProduct);
    	
    	productRepository.save(existingProduct);
    	
    	UpdatedProductResponse response = new UpdatedProductResponse("Product updated.");
    	
        return response;
    }

    @Override
    public DeleteProductByIdResponse delete(DeleteProductByIdRequest request) {
    	Product product = productRepository.findById(request.getId()).orElseThrow();
    	
    	productRepository.delete(product);
    	
    	DeleteProductByIdResponse response = new DeleteProductByIdResponse("Product deleted.");
    	
        return response;
    }

    @Override
    public List<ListProductResponse> getAll() {
        List<Product> products = productRepository.findAll();

        List<ListProductResponse> result = products.stream()
                .map(product -> this.modelMapperService.forResponse().map(product, ListProductResponse.class))
                .collect(Collectors.toList());
        
        return result;
    }

    @Override
    public GetProductByIdResponse getById(GetProductByIdRequest request) {
    	
    	Product product = productRepository.findById(request.getId()).orElseThrow();
    	
    	GetProductByIdResponse response = this.modelMapperService.forResponse().map(product, GetProductByIdResponse.class);
    	
        return response;
    }
}
