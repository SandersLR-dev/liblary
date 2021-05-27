package com.library.domain.dto.checkout;


import com.library.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor

public class CheckoutForm {

    private Book book;
}
