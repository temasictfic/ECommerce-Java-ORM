package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.DeleteCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.GetCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.*;

import java.util.List;


public interface CategoryService {
	
    AddCategoryResponse add(AddCategoryRequest request);
    
    UpdatedCategoryResponse update(UpdateCategoryRequest request);
    
    DeleteCategoryByIdResponse delete(DeleteCategoryRequest request);
    
    List<ListCategoryResponse> getAll();
 
    GetCategoryByIdResponse getById(GetCategoryRequest request);
}
