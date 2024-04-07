package com.tobeto.pairwork_orm.services.rules.abstracts;

public interface ProductBusinessRuleService {
	void productWithSameNameShouldNotExist(String productName);
}
