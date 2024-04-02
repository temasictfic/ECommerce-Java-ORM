package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.core.utilities.exceptions.types.BusinessException;
import com.tobeto.pairwork_orm.core.utilities.mapping.ModelMapperService;
import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.repositories.CategoryRepository;
import com.tobeto.pairwork_orm.services.abstracts.CategoryService;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.DeleteCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.GetCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.UpdatedCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.AddCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.DeleteCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.GetCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListAllCategoryResponse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	private ModelMapperService modelMapperService;

	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
		this.categoryRepository = categoryRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public AddCategoryResponse add(AddCategoryRequest request) {
		categoryWithSameNameShouldNotExist(request.getCategoryName());

		Category category = this.modelMapperService.forRequest().map(request, Category.class);

		Category savedCategory = categoryRepository.save(category);

		AddCategoryResponse response = this.modelMapperService.forResponse().map(savedCategory,
				AddCategoryResponse.class);

		return response;
	}

	@Override
	public UpdatedCategoryResponse update(UpdateCategoryByIdRequest request) {
		categoryWithSameNameShouldNotExist(request.getCategoryName());

		Category category = categoryRepository.findById(request.getId()).orElseThrow();

		category = this.modelMapperService.forRequest().map(request, Category.class);

		// category.setCategoryName(request.getCategoryName());
		Category updatedCategory = categoryRepository.save(category);

		UpdatedCategoryResponse response = this.modelMapperService.forResponse().map(updatedCategory,
				UpdatedCategoryResponse.class);

		return response;
	}

	@Override
	public DeleteCategoryByIdResponse delete(DeleteCategoryByIdRequest request) {
		Category category = categoryRepository.findById(request.getId()).orElseThrow();

		categoryRepository.delete(category);

		DeleteCategoryByIdResponse response = new DeleteCategoryByIdResponse("Category deleted.");

		return response;
	}

	@Override
	public List<ListAllCategoryResponse> getAll() {
		List<Category> categories = categoryRepository.findAll();

		List<ListAllCategoryResponse> response = categories.stream()
				.map(category -> this.modelMapperService.forResponse().map(category, ListAllCategoryResponse.class))
				.collect(Collectors.toList());

		return response;
	}

	@Override
	public GetCategoryByIdResponse getById(GetCategoryByIdRequest request) {
		Category category = categoryRepository.findById(request.getId()).orElseThrow();

		GetCategoryByIdResponse response = this.modelMapperService.forResponse().map(category,
				GetCategoryByIdResponse.class);

		return response;
	}

	// 1. => Anlaşılabilirlik
	// 2. => Uzunluk
	private void categoryWithSameNameShouldNotExist(String name) {
		Optional<Category> categoryWithSameName = categoryRepository.findByCategoryNameIgnoreCase(name);

		if (categoryWithSameName.isPresent())
			throw new BusinessException("Aynı isimde bir kategori zaten var.");
	}
}
