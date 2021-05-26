package com.library.service.impl;

import com.library.domain.dto.publisher.PublisherDto;
import com.library.domain.entity.Publisher;
import com.library.repository.PublisherRepository;
import com.library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    @Override
    @Transactional
    public void createPublisher(PublisherDto publisherDto) {
        Publisher publisher = Publisher.builder()
                .name(publisherDto.getName()).build();
        publisherRepository.save(publisher);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PublisherDto> getPublisherList(Integer page) {
        return null;
    }

    @Override
    @Transactional
    public void deletePublisher(String id) {
        Publisher publisher=publisherRepository.getOne(id);
        publisherRepository.delete(publisher);
    }
}
