package com.tobeto.pairwork_orm.services.dtos.productDtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAllProductResponse {
    private int id;
    private String name;
    private int categoryId;
}
