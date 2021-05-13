package com.example.demo.service;


import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository)
    {
        this.authorRepository= authorRepository;
    }

    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author)
    {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId)
    {
        boolean exists=authorRepository.existsById(authorId);

        if(!exists)
        {
            throw new IllegalStateException("author with id "+ authorId + " doesn't exists");
        }

        authorRepository.deleteById(authorId);
    }

    public void updateAuthor(Long authorId,String name,String surname)
    {
        Author author = authorRepository.findAuthorById(authorId).orElseThrow(()->new IllegalStateException("author wint id "+ authorId+" doesn't exists"));

        if(name!=null && name.length()>0 && !Objects.equals(author.getName(),name))
        {
            author.setName(name);
        }

        if(surname!=null && surname.length()>0 & !Objects.equals(author.getSurname(),surname))
        {
            author.setSurname(surname);
        }

        authorRepository.save(author);
    }
}
