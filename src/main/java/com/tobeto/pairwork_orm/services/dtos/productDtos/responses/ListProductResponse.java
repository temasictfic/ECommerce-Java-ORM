package com.tobeto.pairwork_orm.services.dtos.productDtos.responses;

import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.GetProductPhotosResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProductResponse {
    private int productId;

	private String productName;
	
	private String packageHeight;

	private String packageWidth;
	
	private String packageWeight;
	
	private int categoryId;
	
	private double unitPrice; 
	
	private double unitInStock; 
		
	private List<GetProductPhotosResponse> productPhotos;
}
