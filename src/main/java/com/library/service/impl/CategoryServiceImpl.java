package com.library.service.impl;

import com.library.domain.dto.category.CategoryDto;
import com.library.domain.entity.Category;
import com.library.repository.CategoryRepository;
import com.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryDto categoryDto) {
        Category category = Category.builder()
                .name(categoryDto.getName()).build();

        categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> getCategoryList(Integer page) {
        return null;
    }

    @Override
    @Transactional
    public void deleteCategory(String id) {
        Category category=categoryRepository.getOne(id);
        categoryRepository.delete(category);
    }
}
