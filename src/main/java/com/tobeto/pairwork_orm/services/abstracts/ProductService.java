package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.*;

import java.util.List;

public interface ProductService {

    AddProductResponse add(AddProductRequest request);

    UpdatedProductResponse update(UpdateProductRequest request);

    DeleteProductResponse delete(DeleteProductRequest request);

    List<ListProductResponse> getAll();

    GetProductResponse getById(GetProductRequest request);
}
