package com.library.domain.dto.checkout;

import com.library.domain.entity.Book;
import com.library.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CheckoutDto {

    private String id;
    private User user;
    private Book book;
    private LocalDate checkoutDate;
    private LocalDate returnDate;

}
