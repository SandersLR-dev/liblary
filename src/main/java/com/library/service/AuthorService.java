package com.library.service;

import com.library.domain.dto.author.AuthorDto;

import java.util.List;

public interface AuthorService {

    void createAuthor(AuthorDto authorDto);

    List<AuthorDto> getAuthorList(Integer page);

    void deleteAuthor(String id);
}
