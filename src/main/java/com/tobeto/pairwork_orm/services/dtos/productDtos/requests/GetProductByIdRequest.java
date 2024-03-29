package com.tobeto.pairwork_orm.services.dtos.productDtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIdRequest {
	private int id;
}
