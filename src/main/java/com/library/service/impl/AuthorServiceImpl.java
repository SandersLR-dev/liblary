package com.library.service.impl;

import com.library.domain.dto.author.AuthorDto;
import com.library.domain.entity.Author;
import com.library.domain.mapper.AuthorMapper;
import com.library.repository.AuthorRepository;
import com.library.service.AuthorService;
import com.library.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    @Override
    @Transactional
    public void createAuthor(AuthorDto authorDto) {
        Author author = Author.builder()
                .name(authorDto.getName())
                .surname(authorDto.getSurname()).build();
        authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDto> getAuthorList(Integer page) {
        Pageable currentPage = PageRequest.of(page - 1, Constants.PAGE_SIZE);
        Page<Author> authorList = authorRepository.findAll(currentPage);
        return authorMapper.toAuthorDtoList(authorList.getContent());
    }

    @Override
    @Transactional
    public void deleteAuthor(String id) {
        Author author = authorRepository.getOne(id);
        authorRepository.delete(author);
    }
}
