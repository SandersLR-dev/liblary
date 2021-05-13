package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBook()
    {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId)
    {
        boolean exists=bookRepository.existsById(bookId);

        if(!exists)
        {
            throw new IllegalStateException("book with id "+ bookId + " doesn't exists");
        }

        bookRepository.deleteById(bookId);
    }

}
