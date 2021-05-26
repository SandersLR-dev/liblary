package com.library.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToMany
    private Set<Author> authors;

    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    //TODO zastanowić się nad zmianą na Many to Many
    @ManyToMany
    @JoinColumn(name = "category_id")
    private Set<Category> categories;

}
