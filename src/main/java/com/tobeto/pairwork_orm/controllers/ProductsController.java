package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.services.abstracts.ProductService;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.*;
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


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ListProductResponse> getAll() {
        return productService.getAll();
    }
    
    @GetMapping("/getById")
    @ResponseStatus(HttpStatus.OK)
    public GetProductResponse getById(GetProductRequest request) {
        return productService.getById(request);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddProductResponse add(@RequestBody @Valid AddProductRequest request) {
        return productService.add(request);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdateProductResponse update(@RequestBody @Valid UpdateProductRequest request) {
        return productService.update(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public DeleteProductResponse delete(DeleteProductRequest request) {
        return productService.delete(request);
    }

}
