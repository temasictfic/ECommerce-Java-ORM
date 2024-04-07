package com.tobeto.pairwork_orm.services.dtos.productDtos.requests;

import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoRequest;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
	//TODO: Multi-language
    @NotBlank(message = "İsim alanı boş olamaz.")
    @Size(min=2, max=50, message = "İsim alanı 2 ile 50 karakter arasında olmalıdır.")
    private String productName;

    @NotBlank(message = "Paket yüksekliği boş olamaz.")
    private String packageHeight;

    @NotBlank(message = "Paket genişliği boş olamaz.")
    private String packageWidth;

    @NotBlank(message = "Paket ağırlığı boş olamaz.")
    private String packageWeight;

    @PositiveOrZero(message = "Birim fiyatı 0'dan düşük olamaz.")
    private double unitPrice;

    @PositiveOrZero(message = "Stok adedi 0'dan düşük olamaz.")
    private int unitsInStock;

    private String description;

    private int categoryId;
    
    private List<AddProductPhotoRequest> productPhotos;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /*
    private List<Seller> sellers;*/

}
