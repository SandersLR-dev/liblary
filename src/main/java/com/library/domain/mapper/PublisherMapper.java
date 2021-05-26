package com.library.domain.mapper;

import com.library.domain.dto.publisher.PublisherDto;
import com.library.domain.entity.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PublisherMapper {

    public PublisherDto toPublisherDto(Publisher publisher) {
        if (Objects.isNull(publisher)) {
            return null;
        }
        return PublisherDto.builder()
                .name(publisher.getName()).build();
    }

    public List<PublisherDto> toPublisherDtoList(List<Publisher> publisherList) {
        List<PublisherDto> resultList = new ArrayList<>();
        if (Objects.isNull(publisherList)) {
            return resultList;
        }
        for (Publisher publisher : publisherList) {
            resultList.add(toPublisherDto(publisher));
        }
        return resultList;
    }
}
