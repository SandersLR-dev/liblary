package com.library.service;

import com.library.domain.dto.publisher.PublisherDto;

import java.util.List;

public interface PublisherService {

    void createPublisher(PublisherDto publisherDto);

    List<PublisherDto> getPublisherList(Integer page);

    void deletePublisher(String id);
}
