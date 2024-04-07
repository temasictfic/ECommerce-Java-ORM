package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.AddSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.DeleteSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.UpdateSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.AddSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.DeleteSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.UpdatedSellerResponse;

public interface SellerService {

	AddSellerResponse add(AddSellerRequest request);

	UpdatedSellerResponse update(UpdateSellerRequest request);

	DeleteSellerResponse delete(DeleteSellerRequest request);
}
