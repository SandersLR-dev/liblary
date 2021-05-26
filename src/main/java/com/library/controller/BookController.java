package com.library.controller;


import com.library.domain.dto.book.BookDto;
import com.library.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private BookServiceImpl bookService;

    @PostMapping("/books")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Boolean> createBook(
            @Valid @RequestBody BookDto bookDto)
    {
        bookService.createBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Boolean.TRUE);
    }

    @DeleteMapping("/books/{book_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Boolean> deleteBook(
            @PathVariable(name = "book_id") String bookId)
    {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/books/{user_id}/albums/{page_number}")
    @PreAuthorize("hasAnyRole('USER','AUTHOR', 'ADMIN')")
    public ResponseEntity<List<BookDto>> getBookList(
            @PathVariable(name="page_number") Integer page)
    {
        return ResponseEntity.ok(bookService.getBooksList(page));
    }

    @PutMapping("/books/{book_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Boolean> updateBook(
            @Valid @RequestBody BookDto bookDto)
    {
        //TODO
        return null;
    }

}
