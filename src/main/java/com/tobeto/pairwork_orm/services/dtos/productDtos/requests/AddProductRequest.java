package com.tobeto.pairwork_orm.services.dtos.productDtos.requests;

import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Getter
@Setter
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

    @Positive(message = "Birim fiyatı pozitif olmalıdır.")
    private double unitPrice;

    @Positive(message = "Stok adedi pozitif olmalıdır.")
    private int unitInStock;

    private int categoryId;
    
    private List<AddProductPhotoRequest> productPhotos;
/*
    private List<Seller> sellers;*/

}
