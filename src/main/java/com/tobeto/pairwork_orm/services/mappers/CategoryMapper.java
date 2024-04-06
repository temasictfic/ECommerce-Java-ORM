package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.GetCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    //@Mapping(source = "parentCategory.parentId", target = "parentId")
    Category mapAddCategoryRequestToCategory(AddCategoryRequest request);

    //TODO: Mapping'i tekrar incele(ChatGpt bu şekilde yaptı ama anlamadım?)
    @Mapping(source = "parentId", target = "parentCategory.categoryId")
    @Mapping(source = "categoryName", target = "categoryName")
    Category mapUpdateCategoryRequestToCategory(UpdateCategoryRequest request);

    //Ilk olarak aşağıdaki map islemi yapilmadiginda calisti daha sonra map islemi olmadan esleyebildi.
    //@Mapping(source = "childCategories", target = "childCategories")
    ListCategoryResponse mapCategoryToListCategoryResponse(Category category);

    //Ilk olarak aşağıdaki map islemi yapilmadiginda calisti daha sonra map islemi olmadan esleyebildi.
    //@Mapping(source = "childCategories", target = "childCategories")
    GetCategoryByIdResponse mapCategoryToGetCategoryByIdResponse(Category category);
}
