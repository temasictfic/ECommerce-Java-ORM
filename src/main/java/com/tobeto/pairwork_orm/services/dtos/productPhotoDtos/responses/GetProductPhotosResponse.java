package com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductPhotosResponse {
	private int productPhotoId;
	private String productPhotoUrl;
}
