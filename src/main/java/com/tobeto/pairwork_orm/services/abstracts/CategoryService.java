package com.tobeto.pairwork_orm.services.abstracts;

import java.util.List;

import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.DeleteCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.GetCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.UpdatedCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.AddCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.DeleteCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.GetCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListAllCategoryResponse;


public interface CategoryService {
	
    AddCategoryResponse add(AddCategoryRequest request);
    
    UpdatedCategoryResponse update(UpdateCategoryByIdRequest request);
    
    DeleteCategoryByIdResponse delete(DeleteCategoryByIdRequest request);
    
    List<ListAllCategoryResponse> getAll();
 
    GetCategoryByIdResponse getById(GetCategoryByIdRequest request);
}
