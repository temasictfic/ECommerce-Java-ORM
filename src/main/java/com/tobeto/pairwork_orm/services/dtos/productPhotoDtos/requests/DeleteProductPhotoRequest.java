package com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductPhotoRequest {
	private int productPhotoId;
}
