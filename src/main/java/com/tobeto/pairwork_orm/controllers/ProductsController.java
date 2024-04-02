package com.tobeto.pairwork_orm.controllers;

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
    public GetProductByIdResponse getById(GetProductByIdRequest request) {
        return productService.getById(request);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddProductResponse add(@RequestBody @Valid AddProductRequest request) {
        return productService.add(request);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedProductResponse update(@RequestBody @Valid UpdateProductRequest request) {
        return productService.update(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public DeleteProductByIdResponse delete(DeleteProductByIdRequest request) {
        return productService.delete(request);
    }

}
