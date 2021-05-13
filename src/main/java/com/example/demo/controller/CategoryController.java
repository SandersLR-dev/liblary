package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Publisher;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "lib/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategory()
    {
        return  categoryService.getCategory();
    }

    @PostMapping
    public void addNewCategory(@RequestBody Category category)
    {
        categoryService.addCategory(category);
    }

    @DeleteMapping(path = "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId")Long categoryId)
    {
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping(path = "{categoryId}")
    public void updateCategory(@PathVariable("categoryId") Long categoryId,@RequestParam(required = false)String name)
    {
        categoryService.updateCategory(categoryId,name);
    }

}
