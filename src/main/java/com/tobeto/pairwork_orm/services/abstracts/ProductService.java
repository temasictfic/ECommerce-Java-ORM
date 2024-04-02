package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.*;

import java.util.List;

public interface ProductService {

    AddProductResponse add(AddProductRequest request);

    UpdatedProductResponse update(UpdateProductRequest request);

    DeleteProductByIdResponse delete(DeleteProductByIdRequest request);

    List<ListProductResponse> getAll();

    GetProductByIdResponse getById(GetProductByIdRequest request);
}
