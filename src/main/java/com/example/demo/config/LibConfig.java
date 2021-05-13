package com.example.demo.config;


import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.LibUser;
import com.example.demo.repository.LibUserRepository;
import com.example.demo.role.LibUserRole;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.LibUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class LibConfig {

    private final LibUserService libUserService;

    private final AuthorService authorService;

    private final BookService bookService;

    public LibConfig(LibUserService libUserService, AuthorService authorService, BookService bookService) {
        this.libUserService = libUserService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Bean
    CommandLineRunner commandLineRunner(LibUserRepository libUserRepository,AuthorService authorService,BookService bookService)
    {
        return args -> {



            LibUser dominik= LibUser.builder()
                    .name("Dominik")
                    .surname("Snopek")
                    .username("Dominik123")
                    .dob(LocalDate.of(1999, Month.JUNE,8))
                    .password("password")
                    .libUserRole(LibUserRole.ADMIN)
                    .build();

            libUserService.addNewLibUser(dominik);

            LibUser alek = LibUser.builder()
                    .name("Alek")
                    .surname("Baczynski")
                    .username("Alek123")
                    .dob(LocalDate.of(1999, Month.FEBRUARY,7))
                    .password("12345678")
                    .libUserRole(LibUserRole.USER)
                    .build();

            libUserService.addNewLibUser(alek);

            Author sapkowski =Author.builder()
                    .name("Andrzej")
                    .surname("Sapkowski")
                    .build();

            authorService.addNewAuthor(sapkowski);

            Book wiedzmin = Book.builder()
                    .title("Wiedźmin")
                    .authors(sapkowski)
                    .releaseYear(1990)
                    .numberOfBooks(5)
                    .availableBooks(5)
                    .build();

            bookService.addNewBook(wiedzmin);

        };
    }
}
