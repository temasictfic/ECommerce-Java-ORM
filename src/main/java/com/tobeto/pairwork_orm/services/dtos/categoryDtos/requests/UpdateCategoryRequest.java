package com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests;

import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListCategoryResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequest {
    private int categoryId;

    @Size(min=2, max=50, message = "İsim alanı 2 ile 50 karakter arasında olmalıdır.")
    private String categoryName;

    private Integer parentId;
}
