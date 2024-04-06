package com.tobeto.pairwork_orm.services.dtos.productDtos.requests;

import jakarta.validation.constraints.*;
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

	@NotBlank(message = "Paket yüksekliği boş olamaz.")
	private String packageHeight;

	@NotBlank(message = "Paket genişliği boş olamaz.")
	private String packageWidth;

	@NotBlank(message = "Paket ağırlığı boş olamaz.")
	private String packageWeight;

	private String descriprtion;

	@NotEmpty(message = "Kategori seçilmelidir.")
	private int categoryId;

	@PositiveOrZero(message = "Birim fiyatı 0'dan düşük olamaz.")
	private double unitPrice;

	@PositiveOrZero(message = "Birim fiyatı 0'dan düşük olamaz.")
	private double unitInStock; 
}
