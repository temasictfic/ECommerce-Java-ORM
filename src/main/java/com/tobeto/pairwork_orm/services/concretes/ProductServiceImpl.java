package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.repositories.CategoryRepository;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import com.tobeto.pairwork_orm.services.abstracts.ProductService;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.AddCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListAllCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public AddProductResponse add(AddProductRequest request) {

        Category requestCategory = categoryRepository.findById(request.getCategoryId()).orElseThrow();

        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setPackageHeight(request.getPackageHeight());
        product.setPackageWidth(request.getPackageWidth());
        product.setPackageWeight(request.getPackageWeight());
        product.setUnitPrice(request.getUnitPrice());
        product.setUnitInStock(request.getUnitInStock());
        product.setCategory(requestCategory);
        /*product.setProductPhotos(request.getProductPhotos());
        product.setSellers(request.getSellers());*/

        Product savedProduct = productRepository.save(product);

        AddProductResponse response = new AddProductResponse(savedProduct.getId(), savedProduct.getProductName());

        return response;
    }

    @Override
    public UpdatedProductResponse update(UpdateProductByIdRequest request) {
        return null;
    }

    @Override
    public DeleteProductByIdResponse delete(DeleteProductByIdRequest request) {
        return null;
    }

    @Override
    public List<ListAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();

        List<ListAllProductResponse> result = new ArrayList<>();
        // Listeyi Manual Mapleme - Amatör
        // TODO: Refactor
        for (Product p: products) {
            ListAllProductResponse dto = new ListAllProductResponse(p.getId(), p.getProductName(), p.getCategory().getId());
            result.add(dto);
        }
        return result;
    }

    @Override
    public GetProductByIdResponse getById(GetProductByIdRequest request) {
        return null;
    }
}
