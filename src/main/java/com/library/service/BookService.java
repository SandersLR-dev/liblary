package com.library.service;

import com.library.domain.dto.book.BookDto;

import java.util.List;

public interface BookService {

    void createBook(BookDto bookDto);

    List<BookDto> getBooksList(Integer page);

    void deleteBook(String id);

    //TODO przemyslec dodanie funkcji updateBook
}
