package com.example.demo.controller;


import com.example.demo.entity.Publisher;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "lib/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<Publisher> getPublisher()
    {
        return  publisherService.getPublisher();
    }

    @PostMapping
    public void addNewPublisher(@RequestBody Publisher publisher)
    {
        publisherService.addPublisher(publisher);
    }

    @DeleteMapping(path = "{publisherId}")
    public void deletePublisher(@PathVariable("publisherId")Long publisherId)
    {
        publisherService.deletePublisher(publisherId);
    }

    @PutMapping(path = "{publisherId}")
    public void updatePublisher(@PathVariable("publisherId") Long publisherId,@RequestParam(required = false)String name)
    {
        publisherService.updatePublisher(publisherId,name);
    }

}
