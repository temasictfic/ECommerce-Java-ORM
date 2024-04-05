package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.GetCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.GetCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	Category mapAddCategoryRequestToCategory(AddCategoryRequest request);

	Category mapUpdateCategoryRequestToCategory(UpdateCategoryRequest request);

	ListCategoryResponse mapCategoryToListCategoryResponse(Category category);

	Category mapGetCategoryByIdRequestToCategory(GetCategoryRequest request);

	GetCategoryByIdResponse mapCategoryToGetCategoryByIdResponse(Category category);
}
