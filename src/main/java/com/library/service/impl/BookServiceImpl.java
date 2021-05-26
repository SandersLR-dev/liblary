package com.library.service.impl;

import com.library.domain.dto.book.BookDto;
import com.library.domain.entity.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    @Transactional
    public void createBook(BookDto bookDto) {
        Book book= Book.builder()
                .title(bookDto.getTitle())
                .categories(bookDto.getCategories())
                .publisher(bookDto.getPublisher())
                .releaseYear(bookDto.getReleaseYear())
                .authors(bookDto.getAuthors()).build();
        bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookDto> getBooksList(Integer page) {
        return null;
    }

    @Override
    @Transactional
    public void deleteBook(String id) {
        Book book=bookRepository.getOne(id);
        bookRepository.delete(book);
    }
}
