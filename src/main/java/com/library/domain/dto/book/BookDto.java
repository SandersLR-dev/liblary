package com.library.domain.dto.book;


import com.library.domain.entity.Author;
import com.library.domain.entity.Category;
import com.library.domain.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDto {

    @NotBlank(message = "Title is mandatory")
    String title;

    @NotBlank(message = "Author is mandatory")
    Set<Author> authors;

    @NotBlank(message = "Year is mandatory")
    int releaseYear;

    @NotBlank(message = "Publisher is mandatory")
    Publisher publisher;

    @NotBlank(message = "Category is mandatory")
    Set<Category> categories;
}
