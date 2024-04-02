package com.tobeto.pairwork_orm.services.dtos.productDtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
	
    private int productId;
    
    @NotBlank(message = "İsim alanı boş olamaz.")
    @Size(min=2, max=50, message = "İsim alanı 2 ile 50 karakter arasında olmalıdır.")
    private String productName;
	
	private String packageHeight;

	private String packageWidth;
	
	private String packageWeight;
	
	private String categoryName;
	
	private double unitPrice; 
	
	private double unitInStock; 
}
