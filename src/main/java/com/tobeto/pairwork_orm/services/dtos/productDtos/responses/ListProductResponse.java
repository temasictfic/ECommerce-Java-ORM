package com.tobeto.pairwork_orm.services.dtos.productDtos.responses;

import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.ListProductPhotoResponse;
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

	private String description;
	
	private String categoryName;
	
	private double unitPrice; 
	
	private double unitInStock; 
		
	private List<ListProductPhotoResponse> productPhotos;
	
	private List<ListProductSellerResponse> sellers;
}
