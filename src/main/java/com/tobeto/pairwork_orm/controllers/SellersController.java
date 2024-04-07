package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.services.abstracts.SellerService;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.AddSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.DeleteSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.UpdateSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.AddSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.DeleteSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.UpdatedSellerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/sellers")
public class SellersController {
	
	private SellerService sellerService;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddSellerResponse add(@RequestBody @Valid AddSellerRequest request) {
        return sellerService.add(request);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedSellerResponse update(@RequestBody @Valid UpdateSellerRequest request) {
        return sellerService.update(request);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public DeleteSellerResponse delete(DeleteSellerRequest request) {
        return sellerService.delete(request);
    }
}
