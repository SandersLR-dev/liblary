package com.example.demo.service;


import com.example.demo.entity.Author;
import com.example.demo.entity.Publisher;
import com.example.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getPublisher()
    {
        return publisherRepository.findAll();
    }

    public void addPublisher(Publisher publisher)
    {
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long publisherId)
    {
        boolean exists=publisherRepository.existsById(publisherId);

        if(!exists)
        {
            throw new IllegalStateException("publisher with id "+ publisherId + " doesn't exists");
        }

        publisherRepository.deleteById(publisherId);
    }

    public void updatePublisher(Long publisherId,String name)
    {

        Publisher publisher=publisherRepository.findPublisherById(publisherId).orElseThrow(()->new IllegalStateException("publisher with id "+ publisherId+" doesn't exists"));

        if(name!=null && name.length()>0 && !Objects.equals(publisher.getName(),name))
        {
            publisher.setName(name);
        }

        publisherRepository.save(publisher);
    }

}
