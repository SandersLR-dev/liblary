package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "lib/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService)
    {
        this.authorService=authorService;
    }

    @GetMapping
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }

    @PostMapping
    public void addNewAuthor(@RequestBody Author author)
    {
        authorService.addNewAuthor(author);
    }

    @DeleteMapping(path = "{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long authorId)
    {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping(path = "{authorId}")
    public void updateAuthor(@PathVariable("authorId") Long authorId,@RequestParam(required = false)String name,@RequestParam(required = false)String surname)
    {
        authorService.updateAuthor(authorId,name,surname);
    }
}
