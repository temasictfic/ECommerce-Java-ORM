package com.tobeto.pairwork_orm.services.abstracts;


import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.DeleteCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.GetCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.DeleteCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.GetCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListAllCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.UpdatedCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AddProductRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.DeleteProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.GetProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.UpdateProductByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.productDtos.responses.*;

import java.util.List;

public interface ProductService {

    AddProductResponse add(AddProductRequest request);

    UpdatedProductResponse update(UpdateProductByIdRequest request);

    DeleteProductByIdResponse delete(DeleteProductByIdRequest request);

    List<ListAllProductResponse> getAll();

    GetProductByIdResponse getById(GetProductByIdRequest request);
}
