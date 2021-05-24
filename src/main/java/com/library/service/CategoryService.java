package com.library.service;

import com.library.domain.dto.category.CategoryDto;

import java.util.List;

public interface CategoryService {

    void createCategory(CategoryDto categoryDto);

    List<CategoryDto> getCategoryList(Integer page);

    void deleteCategory(String id);
}
