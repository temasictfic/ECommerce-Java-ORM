package com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductPhotoRequest {	
	private int productId;
	private String productPhotoUrl;
}
