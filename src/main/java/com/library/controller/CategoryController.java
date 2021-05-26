package com.library.controller;


import com.library.domain.dto.author.AuthorDto;
import com.library.domain.dto.book.BookDto;
import com.library.domain.dto.category.CategoryDto;
import com.library.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @PostMapping("/categories")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Boolean> createCategory(
            @Valid @RequestBody CategoryDto categoryDto) {
        categoryService.createCategory(categoryDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Boolean.TRUE);
    }

    @DeleteMapping("/categories/{category_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Boolean> deleteCategoryById(
            @PathVariable(name = "category_id") String categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/categories/{user_id}/albums/{page_number}")
    @PreAuthorize("hasAnyRole('USER','AUTHOR', 'ADMIN')")
    public ResponseEntity<List<CategoryDto>> getCategoryList(
            @PathVariable(name = "page_number") Integer page) {
        return ResponseEntity.ok(categoryService
                .getCategoryList(page));
    }

    @PutMapping("/categories/{category_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Boolean> updateCategory(
            @Valid @RequestBody CategoryDto categoryDto)
    {
        //TODO
        return null;
    }
}
