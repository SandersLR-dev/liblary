package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Publisher;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory()
    {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId)
    {
        boolean exists=categoryRepository.existsById(categoryId);

        if(!exists)
        {
            throw new IllegalStateException("category with id "+ categoryId + " doesn't exists");
        }

        categoryRepository.deleteById(categoryId);
    }

    public void updateCategory(Long categoryId,String name)
    {
        Category category=categoryRepository.findCategoryById(categoryId).orElseThrow(()->new IllegalStateException("category with id "+ categoryId+" doesn't exists"));

        if(name!=null && name.length()>0 && !Objects.equals(category.getName(),name))
        {
            category.setName(name);
        }

        categoryRepository.save(category);
    }
}
