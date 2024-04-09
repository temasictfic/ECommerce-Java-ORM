package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.services.abstracts.CategoryService;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.DeleteCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.GetCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.requests.UpdateCategoryRequest;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.responses.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	private CategoryService categoryService;

	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public List<ListCategoryResponse> getAll() {
		return categoryService.getAll();
	}
	
	@GetMapping("/getById")
    @ResponseStatus(HttpStatus.OK)
    public GetCategoryByIdResponse getById(GetCategoryRequest request) {
        return categoryService.getById(request);
    }

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public AddCategoryResponse add(@RequestBody @Valid AddCategoryRequest request) {
		return categoryService.add(request);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public UpdatedCategoryResponse update(@RequestBody @Valid UpdateCategoryRequest request) {
		return categoryService.update(request);
	}

	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public DeleteCategoryByIdResponse delete(@RequestBody DeleteCategoryRequest request) {
		return categoryService.delete(request);
	}
}
