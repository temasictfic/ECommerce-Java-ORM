package com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductPhotosRequest {
	private int productId;
}
