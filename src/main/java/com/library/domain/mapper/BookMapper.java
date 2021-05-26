package com.library.domain.mapper;

import com.library.domain.dto.author.AuthorDto;

import com.library.domain.dto.book.BookDto;
import com.library.domain.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BookMapper {

    public BookDto toBookDto(Book book) {
        if (Objects.isNull(book)) {
            return null;
        }
        return BookDto.builder()
                .title(book.getTitle())
                .releaseYear(book.getReleaseYear())
                .authors(book.getAuthors())
                .publisher(book.getPublisher())
                .categories(book.getCategories()).build();
    }

    public List<BookDto> toBookDtoList(List<Book> bookList) {
        List<BookDto> resultList = new ArrayList<>();
        if (Objects.isNull(bookList)) {
            return resultList;
        }
        for (Book book : bookList) {
            resultList.add(toBookDto(book));
        }
        return resultList;
    }
}
