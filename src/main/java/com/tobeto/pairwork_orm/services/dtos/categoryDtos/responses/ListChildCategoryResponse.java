package com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListChildCategoryResponse {
    private int categoryId;
    private String categoryName;
    private List<ListChildCategoryResponse> childCategories;
}
