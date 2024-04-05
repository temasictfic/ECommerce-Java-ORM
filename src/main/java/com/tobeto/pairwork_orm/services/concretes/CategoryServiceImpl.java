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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	@Override
	public AddCategoryResponse add(AddCategoryRequest request) {
		categoryWithSameNameShouldNotExist(request.getCategoryName());

		Category category = CategoryMapper.INSTANCE.mapAddCategoryRequestToCategory(request);

		Category savedCategory = categoryRepository.save(category);

		AddCategoryResponse response = new AddCategoryResponse("Category added.");

		return response;
	}

	@Override
	public UpdatedCategoryResponse update(UpdateCategoryRequest request) {
		categoryWithSameNameShouldNotExist(request.getCategoryName());

		Category category = CategoryMapper.INSTANCE.mapUpdateCategoryRequestToCategory(request);

		// category.setCategoryName(request.getCategoryName());
		Category updatedCategory = categoryRepository.save(category);

		UpdatedCategoryResponse response = new UpdatedCategoryResponse("Category updated.");

		return response;
	}

	@Override
	public DeleteCategoryByIdResponse delete(DeleteCategoryRequest request) {
		Category category = categoryRepository.findById(request.getId()).orElseThrow();

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
		Category category = categoryRepository.findById(request.getId()).orElseThrow();

		GetCategoryByIdResponse response = CategoryMapper.INSTANCE.mapCategoryToGetCategoryByIdResponse(category);

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
