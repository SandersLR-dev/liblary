package com.library.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "checkout")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @Column(name = "checkout_date")
    private LocalDate checkoutDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

}
