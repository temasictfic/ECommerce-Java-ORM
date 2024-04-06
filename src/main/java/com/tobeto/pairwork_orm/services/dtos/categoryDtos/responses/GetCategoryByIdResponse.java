package com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses;


import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryByIdResponse {
	private int categoryId;
	private String categoryName;
	private List<ListChildCategoryResponse> childCategories;
}
