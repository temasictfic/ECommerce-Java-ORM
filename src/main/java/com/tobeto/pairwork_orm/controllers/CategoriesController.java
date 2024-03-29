package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.services.abstracts.CategoryService;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.DeleteCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryByIdRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.AddCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.DeleteCategoryByIdResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.ListAllCategoryResponse;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.UpdatedCategoryResponse;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	private CategoryService categoryService;

	public CategoriesController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping
	public List<ListAllCategoryResponse> getAll() {
		return categoryService.getAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddCategoryResponse add(@RequestBody @Valid AddCategoryRequest request) {
		return categoryService.add(request);
	}

	@PutMapping
	public UpdatedCategoryResponse update(@RequestBody @Valid UpdateCategoryByIdRequest request) {
		return categoryService.update(request);
	}

	@DeleteMapping
	public DeleteCategoryByIdResponse delete(@RequestBody DeleteCategoryByIdRequest request) {
		return categoryService.delete(request);
	}
}
