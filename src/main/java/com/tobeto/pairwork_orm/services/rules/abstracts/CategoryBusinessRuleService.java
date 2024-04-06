package com.tobeto.pairwork_orm.services.rules.abstracts;

public interface CategoryBusinessRuleService {
    void categoryWithSameNameShouldNotExist(String categoryName);
}
