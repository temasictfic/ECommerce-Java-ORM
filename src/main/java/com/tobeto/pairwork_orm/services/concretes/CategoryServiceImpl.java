package com.tobeto.pairwork_orm.services.concretes;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
	
    private CategoryRepository categoryRepository;
    

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
    public AddCategoryResponse add(AddCategoryRequest request) {
    	
    	categoryWithSameNameShouldNotExist(request.getName());
    	Category category = new Category();
    	category.setName(request.getName());
    	
    	Category savedCategory = categoryRepository.save(category);
      
    	AddCategoryResponse response = new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());
        
        return response;
    }

    @Override
    public UpdatedCategoryResponse update(UpdateCategoryByIdRequest request) {
    	
    	categoryWithSameNameShouldNotExist(request.getName());
    	
        Category category = categoryRepository.findById(request.getId()).orElseThrow();
        category.setName(request.getName());
        Category updatedCategory = categoryRepository.save(category);
        
        UpdatedCategoryResponse response = new UpdatedCategoryResponse(updatedCategory.getName());
        
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

        List<ListAllCategoryResponse> result = new ArrayList<>();
        // Listeyi Manual Mapleme - Amatör
        // TODO: Refactor
        for (Category c: categories) {
            ListAllCategoryResponse dto = new ListAllCategoryResponse(c.getId(), c.getName());
            result.add(dto);
        }
        return result;
    }

    @Override
    public GetCategoryByIdResponse getById(GetCategoryByIdRequest request) {
    	
        Category category = categoryRepository.findById(request.getId()).orElseThrow();
        
        GetCategoryByIdResponse response = new GetCategoryByIdResponse(category.getId(), category.getName());
        
        return response;
    }
    
    // 1. => Anlaşılabilirlik
    // 2. => Uzunluk
    private void categoryWithSameNameShouldNotExist(String name)
    {
        Optional<Category> categoryWithSameName = categoryRepository.findByNameIgnoreCase(name);

        if(categoryWithSameName.isPresent())
            throw new RuntimeException("Aynı isimde bir kategori zaten var.");
    }
}
