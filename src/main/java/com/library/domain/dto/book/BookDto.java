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

    private String id;

    private String title;

    private Set<Author> authors;

    private int releaseYear;

    private Publisher publisher;

    private Set<Category> categories;


}
