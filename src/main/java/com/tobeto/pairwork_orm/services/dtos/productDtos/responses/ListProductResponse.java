package com.tobeto.pairwork_orm.services.dtos.productDtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProductResponse {
    private int productId;

	private String productName;
	
	private String packageHeight;

	private String packageWidth;
	
	private String packageWeight;
	
	private String categoryName;
	
	private double unitPrice; 
	
	private double unitInStock; 
}
