package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.entities.ERole;
import com.tobeto.pairwork_orm.entities.Role;
import com.tobeto.pairwork_orm.entities.Seller;
import com.tobeto.pairwork_orm.repositories.RoleRepository;
import com.tobeto.pairwork_orm.repositories.SellerRepository;
import com.tobeto.pairwork_orm.services.abstracts.SellerService;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.AddSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.DeleteSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requests.UpdateSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.AddSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.DeleteSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.UpdatedSellerResponse;
import com.tobeto.pairwork_orm.services.mappers.SellerMapper;
import com.tobeto.pairwork_orm.services.rules.concretes.UserBusinessRuleImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService{
	
	private SellerRepository sellerRepository;
	
	private UserBusinessRuleImpl userBusinessRules;
	
	private RoleRepository roleRepository;
	
	
	@Override
	public AddSellerResponse add(AddSellerRequest request) {
		
		userBusinessRules.checkIfUsernameAlreadyExists(request.getUsername());
		userBusinessRules.checkIfEmailAlreadyExists(request.getEmail());
		
		Seller seller = SellerMapper.INSTANCE.mapAddSellerRequestToSeller(request);

		Set<Role> roles = new HashSet<>();

		Role sellerRole = roleRepository.findByRoleName(ERole.ROLE_SELLER)
				.orElseThrow(() -> new BusinessException("Error: Role is not found."));
		roles.add(sellerRole);

		Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
				.orElseThrow(() -> new BusinessException("Error: Role is not found."));
		roles.add(userRole);

		seller.setRoles(roles);

		sellerRepository.save(seller);

		AddSellerResponse response = new AddSellerResponse("Seller added.");

		return response;
	}

	@Override
	public UpdatedSellerResponse update(UpdateSellerRequest request) {

		Seller existingSeller = SellerMapper.INSTANCE.mapUpdateSellerRequestToSeller(request);

		sellerRepository.save(existingSeller);

		UpdatedSellerResponse response = new UpdatedSellerResponse("Seller updated.");

		return response;
	}

	@Override
	public DeleteSellerResponse delete(DeleteSellerRequest request) {
		Seller existingSeller = sellerRepository.findById(request.getSellerId())
				.orElseThrow(() -> new BusinessException("Error: Seller is not found."));

		sellerRepository.delete(existingSeller);

		DeleteSellerResponse response = new DeleteSellerResponse("Seller deleted.");

		return response;
	}

}
