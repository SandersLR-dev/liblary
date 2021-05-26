package com.library.domain.mapper;

import com.library.domain.dto.category.CategoryDto;
import com.library.domain.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    public CategoryDto toCategoryDto(Category category) {
        if(Objects.isNull(category)) {
            return null;
        }
        return CategoryDto.builder()
                .name(category.getName()).build();
    }

    public List<CategoryDto> toCategoryDtoList(List<Category> categoryList) {
        List<CategoryDto> list = new ArrayList<>();
        if(Objects.isNull(categoryList)) {
            return list;
        }
        for (Category category:categoryList) {
            list.add(toCategoryDto(category));
        }
        return list;
    }
}
