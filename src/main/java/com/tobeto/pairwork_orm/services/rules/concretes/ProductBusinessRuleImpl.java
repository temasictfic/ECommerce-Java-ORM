package com.tobeto.pairwork_orm.services.rules.concretes;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import com.tobeto.pairwork_orm.services.rules.abstracts.ProductBusinessRuleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductBusinessRuleImpl implements ProductBusinessRuleService{
	private ProductRepository productRepository;

	@Override
	public void productWithSameNameShouldNotExist(String productName) {
		Optional<Product> productWithSameName = productRepository.findByProductNameIgnoreCase(productName);

        if (productWithSameName.isPresent())
            throw new BusinessException("Aynı isimde bir ürün ismi zaten var.");
	}

}
