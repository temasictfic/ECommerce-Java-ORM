package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.services.abstracts.ProductService;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.AddProductResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.DeleteProductByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.ListAllProductResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.UpdatedProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListAllProductResponse> getAll() {
        return productService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddProductResponse add(@RequestBody @Valid AddProductRequest request) {
        return productService.add(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedProductResponse update(@RequestBody @Valid UpdateProductByIdRequest request) {
        return productService.update(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public DeleteProductByIdResponse delete(@RequestBody DeleteProductByIdRequest request) {
        return productService.delete(request);
    }

}
