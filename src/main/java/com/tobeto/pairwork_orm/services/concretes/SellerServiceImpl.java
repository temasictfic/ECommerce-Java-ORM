package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.entities.Seller;
import com.tobeto.pairwork_orm.repositories.RoleRepository;
import com.tobeto.pairwork_orm.repositories.SellerRepository;
import com.tobeto.pairwork_orm.services.abstracts.SellerService;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes.AddSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes.DeleteSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes.UpdateSellerRequest;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.AddSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.DeleteSellerResponse;
import com.tobeto.pairwork_orm.services.dtos.sellerDtos.responses.UpdateSellerResponse;
import com.tobeto.pairwork_orm.services.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService{
	
	private SellerRepository sellerRepository;
	
	private UserBusinessRules userBusinessRules;
	
	private RoleRepository roleRepository;
	
	
	@Override
	public AddSellerResponse add(AddSellerRequest request) {
		
		userBusinessRules.checkIfUsernameAlreadyExists(request.getUsername());
		userBusinessRules.checkIfEmailAlreadyExists(request.getEmail());
		
		/*Seller seller = this.mapperService.forRequest().map(request, Seller.class);
		
		Set<String> requestedRoles = request.getRoles();

		Set<Role> roles = new HashSet<>();

		Role sellerRole = roleRepository.findByName(ERole.ROLE_SELLER)
				.orElseThrow(() -> new BusinessException("Error: Role is not found."));
		roles.add(sellerRole);

		if (requestedRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new BusinessException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			requestedRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new BusinessException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "customer":
					Role customerRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
							.orElseThrow(() -> new BusinessException("Error: Role is not found."));
					roles.add(customerRole);
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new BusinessException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		seller.setRoles(roles);

		sellerRepository.save(seller);*/

		AddSellerResponse response = new AddSellerResponse("Seller added.");

		return response;
	}

	@Override
	public UpdateSellerResponse update(UpdateSellerRequest request) {

		/*Seller existingSeller = sellerRepository.findById(request.getSellerId())
				.orElseThrow(() -> new BusinessException("Error: Seller is not found."));
		
		userBusinessRules.checkIfUsernameAlreadyExists(request.getUsername());
		userBusinessRules.checkIfEmailAlreadyExists(request.getEmail());
		

		existingSeller = this.mapperService.forRequest().map(request, Seller.class);

		sellerRepository.save(existingSeller);*/

		UpdateSellerResponse response = new UpdateSellerResponse("Seller updated.");

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
