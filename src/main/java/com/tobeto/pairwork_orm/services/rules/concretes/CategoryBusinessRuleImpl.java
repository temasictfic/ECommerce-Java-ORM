package com.tobeto.pairwork_orm.services.rules.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.repositories.CategoryRepository;
import com.tobeto.pairwork_orm.services.rules.abstracts.CategoryBusinessRuleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryBusinessRuleImpl implements CategoryBusinessRuleService {
    private CategoryRepository categoryRepository;

    // 1. => Anlaşılabilirlik
    // 2. => Uzunluk
    @Override
    public void categoryWithSameNameShouldNotExist(String categoryName) {
        Optional<Category> categoryWithSameName = categoryRepository.findByCategoryNameIgnoreCase(categoryName);

        if (categoryWithSameName.isPresent())
            throw new BusinessException("Aynı isimde bir kategori zaten var.");
    }
}
