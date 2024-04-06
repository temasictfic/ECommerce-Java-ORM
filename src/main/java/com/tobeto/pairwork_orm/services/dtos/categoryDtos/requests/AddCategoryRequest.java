package com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests;

import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListCategoryResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {
	//TODO: Multi-language
    @NotBlank(message = "İsim alanı boş olamaz.")
    @Size(min=2, max=50, message = "İsim alanı 2 ile 50 karakter arasında olmalıdır.")
    //@Pattern(regexp = "^(?=.*\\d)(?=.*[!@#$%^&*])(?=.*[a-zA-Z]).{8,}$", message = "İsim en az 8 karakter, 1 numerik, 1 özel sembol içermelidir.")
    private String categoryName;

    private int parentId;
}
