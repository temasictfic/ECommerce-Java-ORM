package com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryByIdResponse {
	private String categoryName;
}
