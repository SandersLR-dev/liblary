package com.example.demo.repository;

import com.example.demo.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {


    Optional<Publisher> findPublisherById(Long id);
}
