package com.tobeto.pairwork_orm.services.dtos.productDtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductRequest {
	private int productId;
}
