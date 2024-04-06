package com.tobeto.pairwork_orm.services.mappers;

import com.tobeto.pairwork_orm.entities.Seller;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes.AddSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes.UpdateSellerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SellerMapper {
    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);
    Seller mapAddSellerRequestToSeller(AddSellerRequest request);
    @Mapping(target = "id", source = "sellerId")
    Seller mapUpdateSellerRequestToSeller(UpdateSellerRequest request);
}
