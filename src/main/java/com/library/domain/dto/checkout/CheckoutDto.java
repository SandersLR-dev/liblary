package com.library.domain.dto.checkout;

import com.library.domain.entity.Book;
import com.library.domain.entity.User;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class CheckoutDto {

    @NotBlank(message = "User is mandatory")
    User user;

    @NotBlank(message = "Book is mandatory")
    Book book;

    @NotBlank(message = "Date is mandatory")
    LocalDate checkoutDate;

    LocalDate returnDate;

}
