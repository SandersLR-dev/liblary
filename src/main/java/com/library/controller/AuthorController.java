package com.library.controller;

import com.library.domain.dto.author.AuthorDto;
import com.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/authors")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Boolean> createAuthor(
            @Valid @RequestBody AuthorDto authorDto) {
        authorService.createAuthor(authorDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Boolean.TRUE);
    }

    @DeleteMapping("/authors/{author_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Boolean> deleteAuthorById(
            @PathVariable(name = "author_id") String authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/users/{user_id}/albums/{page_number}")
    @PreAuthorize("hasAnyRole('USER','AUTHOR', 'ADMIN')")
    public ResponseEntity<List<AuthorDto>> getAuthorList(
            @PathVariable(name = "page_number") Integer page) {
        return ResponseEntity.ok(authorService
                .getAuthorList(page));
    }

    @PutMapping("/authors/{author_id}")
    @PreAuthorize("hasAnyRole('USER','AUTHOR', 'ADMIN')")
    public void updateLibUser(@PathVariable("author_id") String author_id,
                              @Valid @RequestBody AuthorDto authorDto) {
        //TODO
    }

}
