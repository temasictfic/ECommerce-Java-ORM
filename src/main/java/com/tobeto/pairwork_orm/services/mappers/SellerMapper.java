package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.entities.Seller;
import com.tobeto.pairwork_orm.services.dtos.productDtos.requests.AssignProductSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.AddProductPhotoToProductRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.AddSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.UpdateSellerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SellerMapper {
    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);
    
    Seller mapAddSellerRequestToSeller(AddSellerRequest request);
    
    @Mapping(target = "id", source = "sellerId")
    Seller mapUpdateSellerRequestToSeller(UpdateSellerRequest request);
    
    @Mapping(target = "id", source = "sellerId")
    Seller mapAssignProductSellerToProductRequest(AssignProductSellerRequest request);
}
