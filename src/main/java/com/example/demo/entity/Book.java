package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String title;

    @OneToOne
    private Author authors;
    private int releaseYear;
    @OneToOne
    private Publisher publisher;
    @OneToOne
    private Category category;

    private int numberOfBooks;
    private int availableBooks;
}
