package com.tobeto.pairwork_orm.services.dtos.productDtos.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.entities.Seller;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Positive(message = "Birim fiyatı pozitif olmalıdır.")
    private double unitPrice;

    @Positive(message = "Stok adedi pozitif olmalıdır.")
    private int unitInStock;

    private int categoryId;

    private List<ProductPhoto> productPhotos;
/*
    private List<Seller> sellers;*/

}
