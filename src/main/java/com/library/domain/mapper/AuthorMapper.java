package com.library.domain.mapper;

import com.library.domain.dto.author.AuthorDto;
import com.library.domain.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AuthorMapper {

    public AuthorDto toAuthorDto(Author author) {
        if (Objects.isNull(author)) {
            return null;
        }
        return AuthorDto.builder()
                .name(author.getName())
                .surname(author.getSurname()).build();
    }

    public List<AuthorDto> toAuthorDtoList(List<Author> authorList) {
        List<AuthorDto> resultList = new ArrayList<>();
        if (Objects.isNull(authorList)) {
            return resultList;
        }
        for (Author author : authorList) {
            resultList.add(toAuthorDto(author));
        }
        return resultList;
    }
}
