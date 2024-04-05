package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes.AddSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes.DeleteSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes.UpdateSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.AddSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.DeleteSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.UpdateSellerResponse;

public interface SellerService {

	AddSellerResponse add(AddSellerRequest request);

	UpdateSellerResponse update(UpdateSellerRequest request);

	DeleteSellerResponse delete(DeleteSellerRequest request);
}
