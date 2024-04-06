package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.repositories.CategoryRepository;
import com.tobeto.pairwork_orm.services.abstracts.CategoryService;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.DeleteCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.GetCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.*;
import com.tobeto.pairwork_orm.services.mappers.CategoryMapper;
import com.tobeto.pairwork_orm.services.rules.abstracts.CategoryBusinessRuleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	private CategoryBusinessRuleService categoryBusinessRuleService;

	@Override
	public AddCategoryResponse add(AddCategoryRequest request) {
		categoryBusinessRuleService.categoryWithSameNameShouldNotExist(request.getCategoryName());

		Optional<Category> optionalParentCategory = categoryRepository.findById(request.getParentId());

		Category requestedCategory = CategoryMapper.INSTANCE.mapAddCategoryRequestToCategory(request);

		if (optionalParentCategory.isPresent())
		{
			Category parentCategory = optionalParentCategory.get();
			requestedCategory.setParentCategory(parentCategory);
		}
		categoryRepository.save(requestedCategory);

		AddCategoryResponse response = new AddCategoryResponse("Category added.");

		return response;
	}

	@Override
	public UpdatedCategoryResponse update(UpdateCategoryRequest request) {
		//Category category = CategoryMapper.INSTANCE.mapUpdateCategoryRequestToCategory(request);
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
		// parentId null kontrolü
		if (request.getParentId() != null) {
			Optional<Category> optionalParentCategory = categoryRepository.findById(request.getParentId());
			if (optionalParentCategory.isPresent()) {
				category.setParentCategory(optionalParentCategory.get());
			} else {
				throw new BusinessException("Parent category not found.");
			}
		}

		// categoryName güncelleme
		if (request.getCategoryName() != null){
			if (!category.getCategoryName().equals(request.getCategoryName())){
				categoryBusinessRuleService.categoryWithSameNameShouldNotExist(request.getCategoryName());
			}
			category.setCategoryName(request.getCategoryName());
		}


		// parentCategory güncelleme işlemi burada olmamalı, böylece mevcut parent korunur
		categoryRepository.save(category);

		UpdatedCategoryResponse response = new UpdatedCategoryResponse("Category updated.");

		return response;
	}

	@Override
	public DeleteCategoryByIdResponse delete(DeleteCategoryRequest request) {
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
		categoryRepository.delete(category);

		DeleteCategoryByIdResponse response = new DeleteCategoryByIdResponse("Category deleted.");

		return response;
	}

	@Override
	public List<ListCategoryResponse> getAll() {
		List<Category> categories = categoryRepository.findAll();

		List<ListCategoryResponse> response = categories.stream()
				.map(CategoryMapper.INSTANCE::mapCategoryToListCategoryResponse).collect(Collectors.toList());

		return response;
	}

	@Override
	public GetCategoryByIdResponse getById(GetCategoryRequest request) {
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();

		GetCategoryByIdResponse response = CategoryMapper.INSTANCE.mapCategoryToGetCategoryByIdResponse(category);

		return response;
	}
}
